package chiche.server.order.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class GetOrderResponse {
    private Long id;
    private Long idClient;
    private Long idCake;
}
