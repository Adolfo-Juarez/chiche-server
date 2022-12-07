package chiche.server.user.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginResponse {
    private String token;
    private Boolean authorized;
}
