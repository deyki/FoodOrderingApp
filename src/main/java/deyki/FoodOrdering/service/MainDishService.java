package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.mainDish.MainDishBindingModel;
import deyki.FoodOrdering.domain.responseModel.mainDish.MainDishResponseModel;
import deyki.FoodOrdering.error.MainDishNotFoundException;

import java.util.List;

public interface MainDishService {

    void createMainDish(MainDishBindingModel mainDishBindingModel);

    List<MainDishResponseModel> getAllMainDishes();

    MainDishResponseModel getMainDishById(Long mainDishId) throws MainDishNotFoundException;

    MainDishResponseModel getMainDishByName(MainDishBindingModel mainDishBindingModel) throws MainDishNotFoundException;

    void deleteMainDishById(Long mainDishId) throws MainDishNotFoundException;

    void deleteMainDishByName(MainDishBindingModel mainDishBindingModel) throws MainDishNotFoundException;
}