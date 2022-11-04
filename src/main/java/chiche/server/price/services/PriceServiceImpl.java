package chiche.server.price.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.price.controllers.dtos.requests.PostPriceRequest;
import chiche.server.price.controllers.dtos.requests.UpdatePriceRequest;
import chiche.server.price.controllers.dtos.responses.GetPriceResponse;
import chiche.server.price.entities.Price;
import chiche.server.price.repositories.IPriceRepository;
import chiche.server.price.services.interfaces.IPriceService;

@Service
public class PriceServiceImpl implements IPriceService{

    @Autowired
    IPriceRepository repository;

    @Override
    public GetPriceResponse create(PostPriceRequest req) {
        return priceToGetResponse(repository.save(postPricetoPrice(req)));
    }

    @Override
    public List<GetPriceResponse> getByType(String type) {
        return repository.findByType(type)
        .stream()
        .map(this::priceToGetResponse)
        .collect(Collectors.toList());
    }

    @Override
    public List<GetPriceResponse> getByDescription(String description) {
        return repository.findByDescription(description)
                         .stream()
                         .map(this::priceToGetResponse)
                         .collect(Collectors.toList());
    }

    @Override
    public List<GetPriceResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::priceToGetResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetPriceResponse update(UpdatePriceRequest update, String description) {
        return priceToGetResponse(updatePrice(description, update));
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
    
    private Price postPricetoPrice(PostPriceRequest request){
        Price price = new Price();

        price.setType(request.getType());
        price.setDescription(request.getDescription());
        price.setPrice(request.getPrice());
        
        return price;
    }

    private GetPriceResponse priceToGetResponse(Price price){
        GetPriceResponse response = new GetPriceResponse();
        response.setDescription(price.getDescription());
        response.setId(price.getId());
        response.setPrice(price.getPrice());
        response.setType(price.getType());
        return response;
    }

    private Price updatePrice(String description, UpdatePriceRequest update){
        Price price = repository.findByDescription(description).get(0);

        price.setPrice(update.getPrice());

        return repository.save(price);
    }

    @Override
    public float findByDescription(String description){
        return repository.findByDescription(description).get(0).getPrice();
    }

}
