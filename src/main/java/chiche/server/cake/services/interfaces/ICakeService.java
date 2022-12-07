package chiche.server.cake.services.interfaces;

import java.util.List;

import chiche.server.cake.controllers.dtos.requests.PostCakeRequest;
import chiche.server.cake.controllers.dtos.responses.GetCakeResponse;
import chiche.server.cake.entities.Cake;

public interface ICakeService {
    
    public List<GetCakeResponse> list();
    public List<GetCakeResponse> list(String token);
    
    public List<GetCakeResponse> listNoFinished(String token);
    
    public GetCakeResponse get(Long id);

    public GetCakeResponse create(PostCakeRequest request, String token);
    public GetCakeResponse finish(Long id,String token);

    public void delete(Long id);
    public Cake findById(Long id);
}