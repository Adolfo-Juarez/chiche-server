package chiche.server.cake.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import chiche.server.user.entities.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cakes")
@Setter
@Getter
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

    @ManyToOne
    private User user;

    private Date orderedAt;
    private boolean finish;

}
