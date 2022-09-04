package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.user.UserBindingModel;
import deyki.FoodOrdering.domain.responseModel.user.LoginResponseModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void register(UserBindingModel userBindingModel);

    LoginResponseModel login(UserBindingModel userBindingModel);
}
