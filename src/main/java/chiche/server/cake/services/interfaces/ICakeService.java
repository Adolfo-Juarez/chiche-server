package chiche.server.cake.services.interfaces;

import java.util.List;

import chiche.server.cake.controllers.dtos.requests.PostCakeRequest;
import chiche.server.cake.controllers.dtos.requests.UpdateCakeRequest;
import chiche.server.cake.controllers.dtos.responses.GetCakeResponse;
import chiche.server.cake.entities.Cake;

public interface ICakeService {
    
    public List<GetCakeResponse> list();
    public GetCakeResponse get(Long id);

    public GetCakeResponse create(PostCakeRequest request);
    public GetCakeResponse update(Long id,UpdateCakeRequest request);

    public void delete(Long id);
    public Cake findById(Long id);
}