package chiche.server.user.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class GetUserResponse {

    private Long id;
    private String username;

}
