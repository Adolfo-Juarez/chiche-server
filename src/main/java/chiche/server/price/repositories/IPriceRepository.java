package chiche.server.price.repositories;

import org.springframework.stereotype.Repository;

import chiche.server.price.entities.Price;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface IPriceRepository extends JpaRepository<Price, Long>{

    @Query(value = "SELECT * FROM prices WHERE prices.type = :type", nativeQuery = true)
    public List<Price> findByType(String type);

    @Query(value="SELECT * FROM prices WHERE prices.description = :description", nativeQuery = true)
    public List<Price> findByDescription(String description);

}