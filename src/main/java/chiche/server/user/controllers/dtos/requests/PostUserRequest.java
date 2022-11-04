package chiche.server.user.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PostUserRequest {
    private String username;
    private String email;
    private String password;
    private String role ="client";
}
