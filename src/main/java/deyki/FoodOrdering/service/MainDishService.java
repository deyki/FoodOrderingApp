package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.mainDish.MainDishBindingModel;
import deyki.FoodOrdering.domain.responseModel.mainDish.MainDishResponseModel;
import deyki.FoodOrdering.error.MainDishNotFoundException;

import java.util.List;

public interface MainDishService {

    void createMainDish(MainDishBindingModel mainDishBindingModel);

    List<MainDishResponseModel> getAllMainDishes();

    MainDishResponseModel getMainDishById(Long mainDishId) throws MainDishNotFoundException;

    MainDishResponseModel getMainDishByName(String mainDishName) throws MainDishNotFoundException;

    void updateQuantity(QuantityBindingModel quantityBindingModel) throws MainDishNotFoundException;

    void deleteMainDishById(Long mainDishId) throws MainDishNotFoundException;

    void deleteMainDishByName(String mainDishName) throws MainDishNotFoundException;
}
