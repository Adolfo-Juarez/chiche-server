package chiche.server.order.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.cake.services.interfaces.ICakeService;
import chiche.server.order.controllers.dtos.requests.PostOrderRequest;
import chiche.server.order.controllers.dtos.responses.GetOrderResponse;
import chiche.server.order.entities.Order;
import chiche.server.order.repositories.IOrderRepository;
import chiche.server.order.services.interfaces.IOrderService;
import chiche.server.user.services.interfaces.IUserService;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    IOrderRepository repository;

    @Autowired
    IUserService userService;

    @Autowired
    ICakeService cakeService;


    @Override
    public GetOrderResponse create(PostOrderRequest request) {
        return getOrderFromOrder(repository.save(orderFromPostRequest(request)));
    }

    @Override
    public List<GetOrderResponse> list() {
        return repository.findAll()
                            .stream()
                            .map(this::getOrderFromOrder)
                            .collect(Collectors.toList());
    }

    @Override
    public List<GetOrderResponse> getByUserName(String username) {
        return repository
                .findById(userService.getByUsername(username).getId())
                .stream()
                .map(this::getOrderFromOrder)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private GetOrderResponse getOrderFromOrder (Order order){
        GetOrderResponse response = new GetOrderResponse();

        response.setId(order.getId());
        response.setIdCake(order.getCake().getId());
        response.setIdClient(order.getUser().getId());

        return response;
    }
    
    private Order orderFromPostRequest(PostOrderRequest request){
        Order order = new Order();
        order.setCake(cakeService.findById(request.getIdCake()));
        order.setUser(userService.findById(request.getIdUser()));
        return order;
    }

}
