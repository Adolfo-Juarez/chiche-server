package chiche.server.cookie.repositories;

import org.springframework.stereotype.Repository;
import chiche.server.cookie.entities.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;

// No es necesario ninguna acción acá

@Repository
public interface ICookieRepository extends JpaRepository<Cookie, Long>{}
