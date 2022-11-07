package chiche.server.user.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginUserRequest {
    private String password;
}
