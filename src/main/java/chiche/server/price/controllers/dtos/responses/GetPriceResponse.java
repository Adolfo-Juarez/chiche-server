package chiche.server.price.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class GetPriceResponse {

    private Long id;
    private String type;
    private String description;
    private float price;

}
