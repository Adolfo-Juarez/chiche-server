package chiche.server.pancake.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.pancake.repositories.IPancakeRepository;
import chiche.server.pancake.services.interfaces.IPancakeService;

@Service
public class PancakeServiceImpl implements IPancakeService{

    @Autowired
    IPancakeRepository repository;

    // Por Hacer:
    // - Generar métodos en IPancakeService y sobre escribir acá

    // Los métodos del repositorio ya están siendo importados
    // repository.metodo()
    
}
