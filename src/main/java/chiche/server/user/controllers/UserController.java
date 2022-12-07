package chiche.server.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chiche.server.user.controllers.dtos.requests.PostUserRequest;
import chiche.server.user.controllers.dtos.requests.UpdateUserRequest;
import chiche.server.user.controllers.dtos.responses.GetUserResponse;
import chiche.server.user.controllers.dtos.responses.LoginResponse;
import chiche.server.user.services.interfaces.IUserService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    IUserService service;

    @GetMapping
    public List<GetUserResponse> list(){
        return service.list();
    }

    @GetMapping("{username}")
    public GetUserResponse getByUsername(@PathVariable String username){
        return service.getByUsername(username);
    }

    @PostMapping
    public LoginResponse login(@RequestBody PostUserRequest request){
        return service.register(request);
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
