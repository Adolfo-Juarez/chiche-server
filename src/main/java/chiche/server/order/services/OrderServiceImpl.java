package chiche.server.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.order.repositories.IOrderRepository;
import chiche.server.order.services.interfaces.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    IOrderRepository repository;

    // Por Hacer:
    // - Generar métodos en IOrderService y sobre escribir acá

    // Los métodos del repositorio ya están siendo importados
    // repository.metodo()
    
}
