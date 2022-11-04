package chiche.server.cake.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.cake.controllers.dtos.requests.PostCakeRequest;
import chiche.server.cake.controllers.dtos.requests.UpdateCakeRequest;
import chiche.server.cake.controllers.dtos.responses.GetCakeResponse;
import chiche.server.cake.entities.Cake;
import chiche.server.cake.repositories.ICakeRepository;
import chiche.server.cake.services.interfaces.ICakeService;

@Service
public class CakeServiceImpl implements ICakeService{

    @Autowired
    ICakeRepository repository;

    @Override
    public List<GetCakeResponse> list() {
        return repository
               .findAll()
               .stream()
               .map(this::cakeToGetCakeResponse)
               .collect(Collectors.toList());
    }

    @Override
    public GetCakeResponse get(Long id) {
        return cakeToGetCakeResponse(repository
               .findById(id)
               .orElseThrow(()-> 
               new RuntimeException("No se ha encontrado un pastel con el id proporcionado")));
    }

    @Override
    public GetCakeResponse create(PostCakeRequest request) {
        return cakeToGetCakeResponse(
            repository.save(postCakeReqToCake(request))
        );
    }

    @Override
    public GetCakeResponse update(Long id, UpdateCakeRequest request) {
        return cakeToGetCakeResponse(
            repository.save(updateCake(id, request)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Cake updateCake(Long id, UpdateCakeRequest req){

        Cake cake = repository
        .findById(id)
        .orElseThrow(()-> new RuntimeException("No se ha encontrado un pastel para actualizar"));

        if(!req.getBiscuit().isBlank()){
            cake.setBiscuit(req.getBiscuit());
        }

        if(!req.getCoverage().isBlank()){
            cake.setCoverage(req.getCoverage());
        }

        if(!req.getDesign().isBlank()){
            cake.setDesign(req.getDesign());
        }

        if(!req.getFilling().isBlank()){
            cake.setFilling(req.getFilling());
        }

        if(!req.getShape().isBlank()){
            cake.setShape(req.getShape());
        }

        if(!req.isFinish()){
            cake.setFinish(req.isFinish());
        }

        if(!req.getSize().isBlank()){
            cake.setSize(req.getSize());
        }

        return cake;

    }

    private GetCakeResponse cakeToGetCakeResponse (Cake cake){

        GetCakeResponse response = new GetCakeResponse();
        
        response.setBiscuit(cake.getBiscuit());
        response.setCoverage(cake.getCoverage());
        response.setDesign(cake.getDesign());
        response.setFilling(cake.getFilling());
        response.setFinish(cake.isFinish());
        response.setId(cake.getId());
        response.setOrderedAt(cake.getOrderedAt());
        response.setShape(cake.getShape());
        response.setSize(cake.getSize());
        response.setSubtotal(cake.getSubtotal());
        response.setTotal(cake.getTotal());

        return response;
    }

    private Cake postCakeReqToCake (PostCakeRequest request){

        Cake cake = new Cake();

        cake.setBiscuit(request.getBiscuit());
        cake.setCoverage(request.getCoverage());
        cake.setDesign(request.getDesign());
        cake.setFilling(request.getFilling());
        cake.setShape(request.getShape());
        cake.setSize(request.getSize());

        cake.setFinish(false);
        cake.setOrderedAt(new Date());

        return cake;

    }

}