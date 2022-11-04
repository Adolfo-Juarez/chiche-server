package chiche.server.price.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PostPriceRequest {

    private String type;
    private String description;
    private Float price;

}
