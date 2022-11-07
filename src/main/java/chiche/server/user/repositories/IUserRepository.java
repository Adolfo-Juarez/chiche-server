package chiche.server.user.repositories;

import org.springframework.stereotype.Repository;
import chiche.server.user.entities.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// No es necesario ninguna acción acá

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

    @Query(value = "SELECT * FROM users WHERE users.username = :username", nativeQuery = true)
    public List<User> getByUsername (@Param("username") String username);

}
