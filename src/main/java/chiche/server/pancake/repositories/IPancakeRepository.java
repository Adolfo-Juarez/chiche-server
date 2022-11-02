package chiche.server.pancake.repositories;

import org.springframework.stereotype.Repository;
import chiche.server.pancake.entities.Pancake;
import org.springframework.data.jpa.repository.JpaRepository;

// No es necesario ninguna acción acá

@Repository
public interface IPancakeRepository extends JpaRepository<Pancake, Long>{}
