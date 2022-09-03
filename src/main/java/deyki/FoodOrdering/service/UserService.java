package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.user.UserBindingModel;
import deyki.FoodOrdering.domain.responseModel.user.LoginResponseModel;

public interface UserService {

    void register(UserBindingModel userBindingModel);

    LoginResponseModel login(UserBindingModel userBindingModel);
}
