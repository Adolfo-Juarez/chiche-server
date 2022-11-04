package chiche.server.user.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.user.controllers.dtos.requests.PostUserRequest;
import chiche.server.user.controllers.dtos.requests.UpdateUserRequest;
import chiche.server.user.controllers.dtos.responses.GetUserResponse;
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
    public GetUserResponse create(PostUserRequest request) {
        return getUserFromUser(repository.save(userFromPostRequest(request)));
    }

    @Override
    public void delete(String username) {
        repository.deleteById(repository.getByUsername(username).get(0).getId());
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

    @Override
    public User findById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("User no found"));
    }
    
}
