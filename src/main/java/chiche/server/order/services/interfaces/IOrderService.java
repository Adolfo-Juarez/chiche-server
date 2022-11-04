package chiche.server.order.services.interfaces;

import java.util.List;

import chiche.server.order.controllers.dtos.requests.PostOrderRequest;
import chiche.server.order.controllers.dtos.responses.GetOrderResponse;

public interface IOrderService {
    public GetOrderResponse create(PostOrderRequest request);
    public List<GetOrderResponse> list();
    public List<GetOrderResponse> getByUserName(String username);
    public void delete(Long id);
}
