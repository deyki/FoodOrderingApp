package deyki.FoodOrdering.repository;

import deyki.FoodOrdering.domain.entity.Salad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaladRepository extends JpaRepository<Salad, Long> {

    @Query("SELECT s FROM Salad s WHERE s.salad = ?1")
    Optional<Salad> findByName(@Param("name") String name);
}
