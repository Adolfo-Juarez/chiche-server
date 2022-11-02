package chiche.server.blondie.repositories;

import org.springframework.stereotype.Repository;
import chiche.server.blondie.entities.Blondie;
import org.springframework.data.jpa.repository.JpaRepository;

// No es necesario ninguna acción acá

@Repository
public interface IBlondieRepository extends JpaRepository<Blondie, Long>{}
