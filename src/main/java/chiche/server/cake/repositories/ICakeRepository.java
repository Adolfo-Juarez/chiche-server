package chiche.server.cake.repositories;

import org.springframework.stereotype.Repository;
import chiche.server.cake.entities.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ICakeRepository extends JpaRepository<Cake, Long>{}