package chiche.server.cake.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import chiche.server.cake.entities.Cake;

@Repository
public interface ICakeRepository extends JpaRepository<Cake, Long> {
    @Query(value = "SELECT * FROM cakes WHERE cakes.finish = :finish", nativeQuery = true)
    public List<Cake> getByUnfinish(Boolean finish);
}