package deyki.FoodOrdering.repository;

import deyki.FoodOrdering.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.active = true and o.orderType = FullOrder")
    List<Order> findActiveFullOrders();

    @Query("SELECT o FROM Order o WHERE o.active = true and o.orderType = MixedOrder")
    List<Order> findActiveMixedOrders();

    @Query("SELECT o FROM Order o WHERE o.active = true and o.orderType = DrinkOrder")
    List<Order> findActiveDrinkOrders();

    @Query("SELECT o FROM Order o WHERE o.active = true and o.orderType = PizzaOrder")
    List<Order> findActivePizzaOrders();

    @Query("SELECT o FROM Order o WHERE o.active = true and o.orderType = MainDishOrder")
    List<Order> findActiveMainDishOrders();

    @Query("SELECT o FROM Order o WHERE o.active = true and o.orderType = SaladOrder")
    List<Order> findActiveSaladOrders();

    @Query("SELECT o FROM Order o WHERE o.active = true and o.orderType = DessertOrder")
    List<Order> findActiveDessertOrders();

    @Query("SELECT o FROM Order o WHERE o.active = false")
    List<Order> findAllNonActiveOrders();

    @Query("SELECT o FROM Order o WHERE o.active = true")
    List<Order> findAllActiveOrders();
}
