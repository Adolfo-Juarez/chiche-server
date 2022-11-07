package chiche.server.cake.controllers;

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

import chiche.server.cake.controllers.dtos.requests.PostCakeRequest;
import chiche.server.cake.controllers.dtos.requests.UpdateCakeRequest;
import chiche.server.cake.controllers.dtos.responses.GetCakeResponse;
import chiche.server.cake.services.interfaces.ICakeService;

@RestController
@RequestMapping("cake")
public class CakeController {

    @Autowired
    ICakeService service;

    @GetMapping("{id}")
    public GetCakeResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping
    public List<GetCakeResponse> list(){
        return service.list();
    }

    @PostMapping
    public GetCakeResponse create(@RequestBody PostCakeRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public GetCakeResponse update(@PathVariable Long id, @RequestBody UpdateCakeRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
