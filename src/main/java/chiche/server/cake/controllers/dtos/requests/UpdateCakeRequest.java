package chiche.server.cake.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateCakeRequest {
    private String biscuit;
    private String filling;
    private String coverage;
    private String design;
    private String shape;
    private String size;
    private boolean finish;
}
