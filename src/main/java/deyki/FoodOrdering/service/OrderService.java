package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.order.*;
import deyki.FoodOrdering.error.UserNotFoundException;

public interface OrderService {

    void fullOrder(Long userId, FullOrderBindingModel fullOrderBindingModel) throws UserNotFoundException;

    void mixedOrder(Long userId, MixedOrderBindingModel mixedOrderBindingModel) throws UserNotFoundException;

    void drinkOrder(Long userId, DrinkOrderBindingModel drinkOrderBindingModel) throws UserNotFoundException;

    void pizzaOrder(Long userId, PizzaOrderBindingModel pizzaOrderBindingModel) throws UserNotFoundException;

    void mainDishOrder(Long userId, MainDishOrderBindingModel mainDishOrderBindingModel) throws UserNotFoundException;

    void saladOrder(Long userId, SaladOrderBindingModel saladOrderBindingModel) throws UserNotFoundException;

    void dessertOrder(Long userId, DessertOrderBindingModel dessertOrderBindingModel) throws UserNotFoundException;
}
