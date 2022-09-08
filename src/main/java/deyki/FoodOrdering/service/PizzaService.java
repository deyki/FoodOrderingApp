package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.pizza.PizzaBindingModel;
import deyki.FoodOrdering.domain.responseModel.pizza.PizzaResponseModel;
import deyki.FoodOrdering.error.PizzaNotFoundException;

public interface PizzaService {

    void createPizza(PizzaBindingModel pizzaBindingModel);

    PizzaResponseModel getPizzaById(Long pizzaId) throws PizzaNotFoundException;

    PizzaResponseModel getPizzaByName(PizzaBindingModel pizzaBindingModel) throws PizzaNotFoundException;

    void updateQuantity(QuantityBindingModel quantityBindingModel) throws PizzaNotFoundException;

    void deletePizzaById(Long pizzaId) throws PizzaNotFoundException;

    void deletePizzaByName(PizzaBindingModel pizzaBindingModel) throws PizzaNotFoundException;
}
