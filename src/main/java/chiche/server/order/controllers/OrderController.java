package chiche.server.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chiche.server.order.controllers.dtos.requests.PostOrderRequest;
import chiche.server.order.controllers.dtos.responses.GetOrderResponse;
import chiche.server.order.services.interfaces.IOrderService;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

    @Autowired
    IOrderService service;

    @GetMapping
    public List<GetOrderResponse> list(){
        return service.list();
    }

    @GetMapping("{username}")
    public List<GetOrderResponse> getByUsername(@PathVariable String username){
        return service.getByUserName(username);
    }

    @PostMapping
    public GetOrderResponse create (@RequestBody PostOrderRequest request){
        return service.create(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
