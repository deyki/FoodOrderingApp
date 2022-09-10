package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.pizza.PizzaBindingModel;
import deyki.FoodOrdering.domain.responseModel.pizza.PizzaResponseModel;
import deyki.FoodOrdering.error.MenuNotInitializedException;
import deyki.FoodOrdering.error.PizzaNotFoundException;

public interface PizzaService {

    void createPizza(PizzaBindingModel pizzaBindingModel) throws MenuNotInitializedException;

    PizzaResponseModel getPizzaById(Long pizzaId) throws PizzaNotFoundException;

    PizzaResponseModel getPizzaByName(String pizzaName) throws PizzaNotFoundException;

    void updateQuantity(QuantityBindingModel quantityBindingModel) throws PizzaNotFoundException;

    void deletePizzaById(Long pizzaId) throws PizzaNotFoundException;

    void deletePizzaByName(String pizzaName) throws PizzaNotFoundException;
}
