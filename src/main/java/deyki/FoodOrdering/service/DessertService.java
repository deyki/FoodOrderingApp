package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.dessert.DessertBindingModel;
import deyki.FoodOrdering.domain.responseModel.dessert.DessertResponseModel;
import deyki.FoodOrdering.error.DessertNotFoundException;
import deyki.FoodOrdering.error.MenuNotInitializedException;

import java.util.List;

public interface DessertService {

    void createDessert(DessertBindingModel dessertBindingModel) throws MenuNotInitializedException;

    List<DessertResponseModel> getAllDesserts();

    DessertResponseModel getDessertById(Long dessertId) throws DessertNotFoundException;

    DessertResponseModel getDessertByName(String dessertName) throws DessertNotFoundException;

    void updateQuantity(QuantityBindingModel quantityBindingModel) throws DessertNotFoundException;

    void deleteDessertById(Long dessertId) throws DessertNotFoundException;

    void deleteDessertByName(String dessertName) throws DessertNotFoundException;
}
