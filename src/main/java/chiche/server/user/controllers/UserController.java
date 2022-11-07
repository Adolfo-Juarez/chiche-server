package chiche.server.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chiche.server.user.controllers.dtos.requests.LoginUserRequest;
import chiche.server.user.controllers.dtos.requests.PostUserRequest;
import chiche.server.user.controllers.dtos.requests.UpdateUserRequest;
import chiche.server.user.controllers.dtos.responses.GetUserResponse;
import chiche.server.user.controllers.dtos.responses.LoginUserResponse;
import chiche.server.user.services.interfaces.IUserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService service;

    @GetMapping
    public List<GetUserResponse> list(){
        return service.list();
    }

    @GetMapping("{username}")
    public LoginUserResponse getByUsername(@PathVariable String username, @RequestBody LoginUserRequest request){
        return service.login(username, request);
    }

    @PostMapping
    public LoginUserResponse create(@RequestBody PostUserRequest request){
        return service.create(request);
    }

    @PutMapping("{username}")
    public GetUserResponse update(@PathVariable String username, @RequestBody UpdateUserRequest request){
        return service.update(username, request);
    }

    @DeleteMapping("{username}")
    public void delete(@PathVariable String username){
        service.delete(username);
    }

}
