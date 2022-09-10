package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.salad.SaladBindingModel;
import deyki.FoodOrdering.domain.responseModel.salad.SaladResponseModel;
import deyki.FoodOrdering.error.MenuNotInitializedException;
import deyki.FoodOrdering.error.SaladNotFoundException;

import java.util.List;

public interface SaladService {

    void createSalad(SaladBindingModel saladBindingModel) throws MenuNotInitializedException;

    List<SaladResponseModel> getAllSalads();

    SaladResponseModel getSaladById(Long saladId) throws SaladNotFoundException;

    SaladResponseModel getSaladByName(String saladName) throws SaladNotFoundException;

    void updateQuantity(QuantityBindingModel quantityBindingModel) throws SaladNotFoundException;

    void deleteSaladById(Long saladId) throws SaladNotFoundException;

    void deleteSaladByName(String saladName) throws SaladNotFoundException;
}
