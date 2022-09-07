package deyki.FoodOrdering.repository;

import deyki.FoodOrdering.domain.entity.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DessertRepository extends JpaRepository<Dessert, Long> {

    @Query("SELECT d FROM Dessert d WHERE d.dessert = ?1")
    Optional<Dessert> findByName(@Param("name") String name);
}
