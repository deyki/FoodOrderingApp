package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.user.NewPasswordBindingModel;
import deyki.FoodOrdering.domain.bindingModel.user.NewUsernameBindingModel;
import deyki.FoodOrdering.domain.bindingModel.user.UserBindingModel;
import deyki.FoodOrdering.domain.responseModel.user.LoginResponseModel;
import deyki.FoodOrdering.error.IncorrectPasswordException;
import deyki.FoodOrdering.error.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void register(UserBindingModel userBindingModel);

    LoginResponseModel login(UserBindingModel userBindingModel) throws UserNotFoundException, IncorrectPasswordException;

    String updateUsernameById(Long userId, NewUsernameBindingModel newUsernameBindingModel) throws UserNotFoundException;

    String updatePasswordById(Long userId, NewPasswordBindingModel newPasswordBindingModel) throws UserNotFoundException, IncorrectPasswordException;
}
