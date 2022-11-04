package chiche.server.order.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import chiche.server.cake.entities.Cake;
import chiche.server.user.entities.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Setter @Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Cake cake;

}
