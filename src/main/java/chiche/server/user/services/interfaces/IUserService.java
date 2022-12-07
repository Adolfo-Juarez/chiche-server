package chiche.server.user.services.interfaces;

import java.util.List;

import chiche.server.user.controllers.dtos.requests.LoginUserRequest;
import chiche.server.user.controllers.dtos.requests.PostUserRequest;
import chiche.server.user.controllers.dtos.requests.UpdateUserRequest;
import chiche.server.user.controllers.dtos.responses.GetUserResponse;
import chiche.server.user.controllers.dtos.responses.LoginResponse;
import chiche.server.user.entities.User;

public interface IUserService {
    public List<GetUserResponse> list ();

    public LoginResponse login(LoginUserRequest request);
    public LoginResponse register(PostUserRequest request);
    
    public GetUserResponse getByUsername(String username);
    public GetUserResponse update(String username, UpdateUserRequest request);
    public GetUserResponse create(PostUserRequest request);
    public void delete(String username);
    public User findById(Long id);
}
