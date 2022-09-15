package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.responseModel.menu.MenuResponseModel;
import deyki.FoodOrdering.error.MenuAlreadyInitializedException;
import deyki.FoodOrdering.error.MenuNotInitializedException;

public interface MenuService {

    void initMenu() throws MenuAlreadyInitializedException;

    MenuResponseModel getMenu() throws MenuNotInitializedException;

    String deleteMenu() throws MenuNotInitializedException;
}
