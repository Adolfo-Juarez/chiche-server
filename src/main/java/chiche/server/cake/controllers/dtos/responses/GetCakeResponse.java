package chiche.server.cake.controllers.dtos.responses;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class GetCakeResponse {

    private Long id;
    private String biscuit;
    private String filling;
    private String coverage;
    private String design;
    private String shape;
    private String size;
    private Date orderedAt;
    private boolean finish;

}