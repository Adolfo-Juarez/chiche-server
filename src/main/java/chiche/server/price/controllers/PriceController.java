package chiche.server.price.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chiche.server.price.controllers.dtos.requests.PostPriceRequest;
import chiche.server.price.controllers.dtos.requests.UpdatePriceRequest;
import chiche.server.price.controllers.dtos.responses.GetPriceResponse;
import chiche.server.price.services.interfaces.IPriceService;

@RestController
@RequestMapping("price")
public class PriceController {

    @Autowired
    IPriceService service;

    @GetMapping()
    public List<GetPriceResponse> list(){
        return service.list();
    }

    @GetMapping("type")
    public List<GetPriceResponse> getByType (@RequestParam String name){
        return service.getByType(name);
    }

    @GetMapping("description")
    public List<GetPriceResponse> getByDescription(@RequestParam String name){
        return service.getByDescription(name);
    }

    @PostMapping()
    public GetPriceResponse create(@RequestBody PostPriceRequest request){
        return service.create(request);
    }

    @PutMapping("{description}")
    public GetPriceResponse update(@PathVariable String description, @RequestBody UpdatePriceRequest request){
        return service.update(request, description);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        service.remove(id);
    }

}
