package chiche.server.user.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.security.Encryptor;
import chiche.server.security.Tokens;
import chiche.server.user.controllers.dtos.requests.LoginUserRequest;
import chiche.server.user.controllers.dtos.requests.PostUserRequest;
import chiche.server.user.controllers.dtos.requests.UpdateUserRequest;
import chiche.server.user.controllers.dtos.responses.GetUserResponse;
import chiche.server.user.controllers.dtos.responses.LoginResponse;
import chiche.server.user.entities.User;
import chiche.server.user.repositories.IUserRepository;
import chiche.server.user.services.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {

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
        return getUserFromUser(repository.getByEmail(username).get(0));
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
        repository.deleteById(repository.getByEmail(username).get(0).getId());
    }

    @Override
    public LoginResponse login(LoginUserRequest request) {

        Encryptor encryp = new Encryptor();

        LoginResponse response = new LoginResponse();

        List<User> users = repository.getByEmail(request.getEmail());

        if (users.isEmpty()) {
            response.setAuthorized(false);
            response.setToken("email not found");
            return response;
        }

        if(!encryp.validate(request.getPassword(), users.get(0).getPassword())){
            response.setAuthorized(false);
            response.setToken("password dont match");
            return response;
        }

        return loginResponseFromUser(users.get(0));

    }

    @Override
    public LoginResponse register(PostUserRequest request) {
        LoginResponse response = new LoginResponse();

        if (!repository.getByEmail(request.getEmail()).isEmpty()) {
            response.setAuthorized(false);
            response.setToken("not available");
            return response;
        }

        return loginResponseFromUser(repository.save(userFromPostRequest(request)));

    }

    private User userFromPostRequest(PostUserRequest request) {
        Encryptor encry = new Encryptor();

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(encry.encrypt(request.getPassword()));
        user.setRole(request.getRole());

        return user;
    }

    private LoginResponse loginResponseFromUser(User user) {
        Tokens token = new Tokens();
        LoginResponse response = new LoginResponse();

        response.setAuthorized(true);
        response.setToken(token.generateToken(
                user.getId().toString(),
                user.getRole(),
                user.getUsername(),
                (long) 3600000));

        return response;
    }

    private GetUserResponse getUserFromUser(User user) {
        GetUserResponse response = new GetUserResponse();

        response.setId(user.getId());
        response.setUsername(user.getUsername());

        return response;
    }

    private User userFromUpdateRequest(UpdateUserRequest request, String Username) {
        User user = repository.getByEmail(Username).get(0);

        user.setUsername(request.getUsername());

        return user;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User no found"));
    }

}
