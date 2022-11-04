package chiche.server.order.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PostOrderRequest {
    private Long idUser;
    private Long idCake;
}
