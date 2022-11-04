package chiche.server.order.repositories;

import org.springframework.stereotype.Repository;
import chiche.server.order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// No es necesario ninguna acción acá

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>{}
