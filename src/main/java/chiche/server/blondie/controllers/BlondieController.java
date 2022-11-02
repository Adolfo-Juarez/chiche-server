package chiche.server.blondie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chiche.server.blondie.services.interfaces.IBlondieService;

@RestController
@RequestMapping("blondie")
public class BlondieController {

    @Autowired
    IBlondieService service;

    // Por Hacer:
    // - Agregar las rutas correspondientes para las peticiones HTTP
    //     - GET, POST, UPDATE y DELETE

    // La interfaz del servicio ya están importados

    // Si accedes a localhost:8080/blondie podrás ver el mensaje
    @GetMapping
    public String HelloWorld() {
        return "Hello World, we're in Blondie";
    }

}
