package deyki.FoodOrdering.repository;

import deyki.FoodOrdering.domain.entity.MainDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainDishRepository extends JpaRepository<MainDish, Long> {

    @Query("SELECT m FROM MainDish m WHERE m.mainDish = ?1")
    Optional<MainDish> findByName(@Param("name") String name);
}
