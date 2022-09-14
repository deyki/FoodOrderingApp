package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.bindingModel.user.UserBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.EmailBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.PhoneNumberBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.UpdateDetailsBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.UserProfileDetailsBindingModel;
import deyki.FoodOrdering.domain.responseModel.userProfileDetails.UserProfileDetailsResponseModel;
import deyki.FoodOrdering.error.UserNotFoundException;
import deyki.FoodOrdering.error.UserProfileDetailsNotFoundException;

public interface UserProfileDetailsService {

    void createUserProfileDetails(UserProfileDetailsBindingModel userProfileDetailsBindingModel) throws UserNotFoundException;

    UserProfileDetailsResponseModel getUserProfileDetailsByEmail(EmailBindingModel emailBindingModel) throws UserProfileDetailsNotFoundException;

    UserProfileDetailsResponseModel getUserProfileDetailsByPhoneNumber(PhoneNumberBindingModel phoneNumberBindingModel) throws UserProfileDetailsNotFoundException;

    void updateUserProfileDetailsById(Long userDetailsId, UpdateDetailsBindingModel updateDetailsBindingModel) throws UserProfileDetailsNotFoundException;

    String getPointsById(Long userId) throws UserProfileDetailsNotFoundException;
}
