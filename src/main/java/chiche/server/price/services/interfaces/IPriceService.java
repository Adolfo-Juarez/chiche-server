package chiche.server.price.services.interfaces;

import java.util.List;

import chiche.server.price.controllers.dtos.requests.PostPriceRequest;
import chiche.server.price.controllers.dtos.requests.UpdatePriceRequest;
import chiche.server.price.controllers.dtos.responses.GetPriceResponse;

public interface IPriceService {

    public GetPriceResponse create(PostPriceRequest req);
    public List<GetPriceResponse> getByType(String type);
    public List<GetPriceResponse> getByDescription(String description);
    public List<GetPriceResponse> list();

    public GetPriceResponse update(UpdatePriceRequest update, String description);
    public void remove(Long id);

}
