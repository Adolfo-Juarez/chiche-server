package chiche.server.cake.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PostCakeRequest {
    private String biscuit;
    private String filling;
    private String coverage;
    private String design;
    private String shape;
    private String size;
}