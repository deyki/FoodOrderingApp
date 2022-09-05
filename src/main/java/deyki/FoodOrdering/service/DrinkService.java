package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.drink.DrinkBindingModel;
import deyki.FoodOrdering.domain.responseModel.drink.DrinkResponseModel;
import deyki.FoodOrdering.error.DrinkNotFoundException;

import java.util.List;

public interface DrinkService {

    void createDrink(DrinkBindingModel drinkBindingModel);

    List<DrinkResponseModel> getAllDrinks();

    DrinkResponseModel getDrinkById(Long drinkId) throws DrinkNotFoundException;
}
