package chiche.server.cake.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import chiche.server.order.entities.Order;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cakes")
@Setter @Getter
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String biscuit;
    private String filling;
    private String coverage;
    private String design;
    private String shape;
    private String size;
    private Float subtotal;
    private Float total;

    private Date orderedAt;
    private boolean finish;

    @OneToMany(mappedBy = "cake")
    private List<Order> order;

}
