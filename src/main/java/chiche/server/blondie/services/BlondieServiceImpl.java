package chiche.server.blondie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.blondie.repositories.IBlondieRepository;
import chiche.server.blondie.services.interfaces.IBlondieService;

@Service
public class BlondieServiceImpl implements IBlondieService{

    @Autowired
    IBlondieRepository repository;

    // Por Hacer:
    // - Generar métodos en IBlondieService y sobre escribir acá

    // Los métodos del repositorio ya están siendo importados
    // repository.metodo()
    
}
