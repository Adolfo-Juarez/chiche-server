package chiche.server.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chiche.server.user.services.interfaces.IUserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService service;

    // Por Hacer:
    // - Agregar las rutas correspondientes para las peticiones HTTP
    //     - GET, POST, UPDATE y DELETE

    // La interfaz del servicio ya están importados

    // Si accedes a localhost:8080/user podrás ver el mensaje
    @GetMapping
    public String HelloWorld() {
        return "Hello World, we're in User";
    }

}
