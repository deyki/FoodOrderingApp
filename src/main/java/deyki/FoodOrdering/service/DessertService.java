package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.dessert.DessertBindingModel;
import deyki.FoodOrdering.domain.responseModel.dessert.DessertResponseModel;
import deyki.FoodOrdering.error.DessertNotFoundException;

import java.util.List;

public interface DessertService {

    void createDessert(DessertBindingModel dessertBindingModel);

    List<DessertResponseModel> getAllDesserts();

    DessertResponseModel getDessertById(Long dessertId) throws DessertNotFoundException;

    DessertResponseModel getDessertByName(DessertBindingModel dessertBindingModel) throws DessertNotFoundException;

    void deleteDessertById(Long dessertId) throws DessertNotFoundException;

    void deleteDessertByName(DessertBindingModel dessertBindingModel) throws DessertNotFoundException;
}