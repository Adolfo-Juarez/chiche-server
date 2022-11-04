package chiche.server.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chiche.server.user.repositories.IUserRepository;
import chiche.server.user.services.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository repository;

    // Por Hacer:
    // - Generar métodos en IUserService y sobre escribir acá

    // Los métodos del repositorio ya están siendo importados
    // repository.metodo()
    
}
