package chiche.server.user.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginUserResponse {
    private Boolean logged;
    private String username;
    private Long id;   
}
