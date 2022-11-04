package chiche.server.user.repositories;

import org.springframework.stereotype.Repository;
import chiche.server.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// No es necesario ninguna acción acá

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{}
