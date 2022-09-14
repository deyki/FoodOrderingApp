package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.order.*;
import deyki.FoodOrdering.domain.entity.Order;
import deyki.FoodOrdering.domain.responseModel.order.*;
import deyki.FoodOrdering.domain.responseModel.user.UserResponseModel;
import deyki.FoodOrdering.error.OrderNotFoundException;
import deyki.FoodOrdering.error.UserNotFoundException;

import java.util.List;

public interface OrderService {

    void fullOrder(Long userId, FullOrderBindingModel fullOrderBindingModel) throws UserNotFoundException;

    void mixedOrder(Long userId, MixedOrderBindingModel mixedOrderBindingModel) throws UserNotFoundException;

    void drinkOrder(Long userId, DrinkOrderBindingModel drinkOrderBindingModel) throws UserNotFoundException;

    void pizzaOrder(Long userId, PizzaOrderBindingModel pizzaOrderBindingModel) throws UserNotFoundException;

    void mainDishOrder(Long userId, MainDishOrderBindingModel mainDishOrderBindingModel) throws UserNotFoundException;

    void saladOrder(Long userId, SaladOrderBindingModel saladOrderBindingModel) throws UserNotFoundException;

    void dessertOrder(Long userId, DessertOrderBindingModel dessertOrderBindingModel) throws UserNotFoundException;

    List<FullOrderResponseModel> getListOfActiveFullOrders();

    List<MixedOrderResponseModel> getListOfActiveMixedOrders();

    List<DrinkOrderResponseModel> getListOfActiveDrinkOrders();

    List<PizzaOrderResponseModel> getListOfActivePizzaOrders();

    List<MainDishOrderResponseModel> getListOfActiveMainDishOrders();

    List<SaladOrderResponseModel> getListOfActiveSaladOrders();

    List<DessertOrderResponseModel> getListOfActiveDessertOrders();

    List<OrderResponseModel> getListOfActiveOrders();
    List<Order> getListOfNonActiveOrders();

    Order getOrderById(Long orderId) throws OrderNotFoundException;

    void updateActiveById(Long orderId) throws OrderNotFoundException;

    UserResponseModel getUserInfoByOrderId(Long orderId) throws OrderNotFoundException;

    String deleteOrderById(Long orderId) throws OrderNotFoundException;
}
