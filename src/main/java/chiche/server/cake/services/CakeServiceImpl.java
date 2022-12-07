package chiche.server.cake.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.cake.controllers.dtos.requests.PostCakeRequest;
import chiche.server.cake.controllers.dtos.responses.GetCakeResponse;
import chiche.server.cake.entities.Cake;
import chiche.server.cake.repositories.ICakeRepository;
import chiche.server.cake.services.interfaces.ICakeService;
import chiche.server.price.services.interfaces.IPriceService;
import chiche.server.security.Tokens;
import chiche.server.user.services.interfaces.IUserService;

@Service
public class CakeServiceImpl implements ICakeService {

    @Autowired
    ICakeRepository repository;

    @Autowired
    IPriceService priceService;

    @Autowired
    IUserService userService;

    @Override
    public List<GetCakeResponse> list() {
        return repository
                .findAll()
                .stream()
                .map(this::cakeToGetCakeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetCakeResponse get(Long id) {
        return cakeToGetCakeResponse(repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado un pastel con el id proporcionado")));
    }

    @Override
    public GetCakeResponse create(PostCakeRequest request, String token) {

        Tokens tk = new Tokens();

        if (!tk.validate(token)) {
            GetCakeResponse response = new GetCakeResponse();
            response.setStatus("Token looks weird");
            response.setFinish(true);
            return response;
        }

        return cakeToGetCakeResponse(
                repository.save(postCakeReqToCake(request, token)));
    }

    @Override
    public GetCakeResponse finish(Long id, String token) {
        Tokens tk = new Tokens();

        if (!tk.validate(token)) {
            GetCakeResponse response = new GetCakeResponse();
            response.setStatus("Invalid Token");
            return response;
        }

        return cakeToGetCakeResponse(
                repository.save(finishOrder(id)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<GetCakeResponse> list(String token) {
        Tokens tk = new Tokens();

        if (tk.validate(token)) {
            return userService.findById(tk.readId(token))
                    .getCakes()
                    .stream()
                    .map(this::cakeToGetCakeResponse)
                    .collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public List<GetCakeResponse> listNoFinished(String token) {

        Tokens tk = new Tokens();

        if (tk.readPrivilegies(token).equals("admin")) {

            return repository.getByUnfinish(false)
                    .stream()
                    .map(this::cakeToGetCakeResponse)
                    .collect(Collectors.toList());
        }

        return null;

    }

    private Cake finishOrder(Long id) {

        Cake cake = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado un pastel para actualizar"));

        cake.setFinish(true);

        return cake;

    }

    private GetCakeResponse cakeToGetCakeResponse(Cake cake) {

        GetCakeResponse response = new GetCakeResponse();

        response.setBiscuit(cake.getBiscuit());
        response.setCoverage(cake.getCoverage());
        response.setDesign(cake.getDesign());
        response.setFilling(cake.getFilling());
        response.setFinish(cake.isFinish());
        response.setId(cake.getId());
        response.setOrderedAt(cake.getOrderedAt());
        response.setShape(cake.getShape());
        response.setSize(cake.getSize());
        response.setSubtotal(cake.getSubtotal());
        response.setTotal(cake.getTotal());
        response.setStatus("great");

        return response;
    }

    private Cake postCakeReqToCake(PostCakeRequest request, String token) {

        Tokens tk = new Tokens();
        float subtotal = 0;
        Cake cake = new Cake();

        cake.setBiscuit(request.getBiscuit());
        subtotal += priceService.findByDescription(request.getBiscuit());

        cake.setCoverage(request.getCoverage());
        subtotal += priceService.findByDescription(request.getCoverage());

        cake.setDesign(request.getDesign());
        subtotal += priceService.findByDescription(request.getDesign());

        cake.setFilling(request.getFilling());
        subtotal += priceService.findByDescription(request.getFilling());

        cake.setShape(request.getShape());
        subtotal += priceService.findByDescription(request.getShape());

        cake.setSize(request.getSize());
        subtotal += priceService.findByDescription(request.getSize());

        cake.setSubtotal(subtotal);
        cake.setTotal((subtotal / 100) * 116);

        cake.setFinish(false);
        cake.setOrderedAt(new Date());

        cake.setUser(userService.findById(tk.readId(token)));

        return cake;

    }

    @Override
    public Cake findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pastel no encontrado"));
    }

}