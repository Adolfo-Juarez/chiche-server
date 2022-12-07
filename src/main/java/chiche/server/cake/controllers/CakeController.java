package chiche.server.cake.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chiche.server.cake.controllers.dtos.requests.PostCakeRequest;
import chiche.server.cake.controllers.dtos.responses.GetCakeResponse;
import chiche.server.cake.services.interfaces.ICakeService;
import chiche.server.utility.TokensTransform;

@CrossOrigin
@RestController
@RequestMapping("cake")
public class CakeController {

    @Autowired
    ICakeService service;

    @GetMapping("{id}")
    public GetCakeResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<GetCakeResponse> list(@RequestHeader(value = "Authorization") String token) {
        TokensTransform tk = new TokensTransform();
        return service.listNoFinished(tk.getToken(token));
    }

    @GetMapping("order")
    public List<GetCakeResponse> myOrders(@RequestHeader(value = "Authorization") String token) {
        TokensTransform tk = new TokensTransform();
        return service.list(tk.getToken(token));
    }

    @PostMapping
    public GetCakeResponse create(@RequestBody PostCakeRequest request,
            @RequestHeader(value = "Authorization") String token) {
        TokensTransform tk = new TokensTransform();
        return service.create(request, tk.getToken(token));
    }

    @PutMapping("{id}")
    public GetCakeResponse update(@PathVariable Long id,@RequestHeader(value = "Authorization") String token) {
        TokensTransform tk = new TokensTransform();
        return service.finish(id, tk.getToken(token));
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
