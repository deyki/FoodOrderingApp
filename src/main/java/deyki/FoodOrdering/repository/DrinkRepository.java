package deyki.FoodOrdering.repository;

import deyki.FoodOrdering.domain.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

    @Query("SELECT d FROM Drink d WHERE d.drink = ?1")
    Optional<Drink> findByDrink(@Param("drink") String drink);
}
