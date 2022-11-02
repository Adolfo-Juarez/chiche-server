package chiche.server.cookie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.cookie.repositories.ICookieRepository;
import chiche.server.cookie.services.interfaces.ICookieService;

@Service
public class CookieServiceImpl implements ICookieService{

    @Autowired
    ICookieRepository repository;

    // Por Hacer:
    // - Generar métodos en ICookieService y sobre escribir acá

    // Los métodos del repositorio ya están siendo importados
    // repository.metodo()
    
}
