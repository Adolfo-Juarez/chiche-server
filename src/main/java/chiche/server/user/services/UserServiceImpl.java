package chiche.server.user.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.user.controllers.dtos.requests.LoginUserRequest;
import chiche.server.user.controllers.dtos.requests.PostUserRequest;
import chiche.server.user.controllers.dtos.requests.UpdateUserRequest;
import chiche.server.user.controllers.dtos.responses.GetUserResponse;
import chiche.server.user.controllers.dtos.responses.LoginUserResponse;
import chiche.server.user.entities.User;
import chiche.server.user.repositories.IUserRepository;
import chiche.server.user.services.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository repository;

    @Override
    public List<GetUserResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::getUserFromUser)
                .collect(Collectors.toList());
    }

    @Override
    public GetUserResponse getByUsername(String username) {
        return getUserFromUser(repository.getByUsername(username).get(0));
    }

    @Override
    public GetUserResponse update(String username, UpdateUserRequest request) {
        return getUserFromUser(repository.save(userFromUpdateRequest(request, username)));
    }

    @Override
    public LoginUserResponse create(PostUserRequest request) {
        return createAndLogin(request);
    }
    
    @Override
    public void delete(String username) {
        repository.deleteById(repository.getByUsername(username).get(0).getId());
    }
    
    @Override
    public LoginUserResponse login(String username, LoginUserRequest request){
        return validatePassword(username, request);
    }
    
    @Override
    public User findById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("User no found"));
    }

    private User userFromPostRequest (PostUserRequest request){
        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return user;
    }

    private GetUserResponse getUserFromUser(User user){
        GetUserResponse response = new GetUserResponse();

        response.setId(user.getId());
        response.setUsername(user.getUsername());

        return response;
    }

    private User userFromUpdateRequest(UpdateUserRequest request, String Username){
        User user = repository.getByUsername(Username).get(0);
        
        user.setUsername(request.getUsername());

        return user;
    }

    private LoginUserResponse validatePassword(String username, LoginUserRequest pwd){
        LoginUserResponse response = new LoginUserResponse();
        User user = repository.getByUsername(username).get(0);

        if(!user.getPassword().equals(pwd.getPassword())){
            response.setLogged(false);
            return response;
        }

        response.setId(user.getId());
        response.setLogged(true);
        response.setUsername(user.getUsername());

        return response;
    }

    private LoginUserResponse createAndLogin(PostUserRequest request){
        LoginUserResponse response = new LoginUserResponse();

        if(!repository.getByUsername(request.getUsername()).isEmpty()){
            response.setLogged(false);
            return response;
        }

        User user = repository.save(userFromPostRequest(request));

        response.setId(user.getId());
        response.setLogged(true);
        response.setUsername(user.getUsername());

        return response;
    }

}
