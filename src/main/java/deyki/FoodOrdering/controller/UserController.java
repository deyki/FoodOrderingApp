package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.EmailBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.PhoneNumberBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.UpdateDetailsBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.UserProfileDetailsBindingModel;
import deyki.FoodOrdering.domain.responseModel.userProfileDetails.UserProfileDetailsResponseModel;
import deyki.FoodOrdering.error.UserNotFoundException;
import deyki.FoodOrdering.error.UserProfileDetailsNotFoundException;
import deyki.FoodOrdering.service.impl.UserProfileDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryConfigurationSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserProfileDetailsServiceImpl userProfileDetailsService;

    @Autowired
    public UserController(UserProfileDetailsServiceImpl userProfileDetailsService) {
        this.userProfileDetailsService = userProfileDetailsService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProfileDetails(@RequestBody UserProfileDetailsBindingModel userProfileDetailsBindingModel) throws UserNotFoundException {

        userProfileDetailsService.createUserProfileDetails(userProfileDetailsBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("User profile details created!");
    }

    @GetMapping("/getDetailsByEmail")
    public ResponseEntity<UserProfileDetailsResponseModel> getProfileDetailsByEmail(@RequestBody EmailBindingModel emailBindingModel) throws UserProfileDetailsNotFoundException {

        UserProfileDetailsResponseModel responseModel = userProfileDetailsService.getUserProfileDetailsByEmail(emailBindingModel);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @GetMapping("/getDetailsByPhoneNumber")
    public ResponseEntity<UserProfileDetailsResponseModel> getDetailsByPhoneNumber(@RequestBody PhoneNumberBindingModel phoneNumberBindingModel) throws UserProfileDetailsNotFoundException {

        UserProfileDetailsResponseModel responseModel = userProfileDetailsService.getUserProfileDetailsByPhoneNumber(phoneNumberBindingModel);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @PutMapping("/updateDetailsById/{userDetailsId}")
    public ResponseEntity<String> updateDetailsById(@PathVariable Long userDetailsId, @RequestBody UpdateDetailsBindingModel updateDetailsBindingModel) throws UserProfileDetailsNotFoundException {

        userProfileDetailsService.updateUserProfileDetailsById(userDetailsId, updateDetailsBindingModel);

        return ResponseEntity.status(HttpStatus.OK).body("Details updated successfully!");
    }
}
