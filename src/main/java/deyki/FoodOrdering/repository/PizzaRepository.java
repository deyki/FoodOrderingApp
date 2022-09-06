package deyki.FoodOrdering.repository;

import deyki.FoodOrdering.domain.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    @Query("SELECT p FROM Pizza p WHERE p.pizza = ?1")
    Optional<Pizza> findByName(@Param("name") String name);
}
