package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.bindingModel.user.NewPasswordBindingModel;
import deyki.FoodOrdering.domain.bindingModel.user.NewUsernameBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.EmailBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.PhoneNumberBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.UpdateDetailsBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.UserProfileDetailsBindingModel;
import deyki.FoodOrdering.domain.responseModel.userProfileDetails.UserProfileDetailsResponseModel;
import deyki.FoodOrdering.error.IncorrectPasswordException;
import deyki.FoodOrdering.error.UserNotFoundException;
import deyki.FoodOrdering.error.UserProfileDetailsNotFoundException;
import deyki.FoodOrdering.service.impl.UserProfileDetailsServiceImpl;
import deyki.FoodOrdering.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserProfileDetailsServiceImpl userProfileDetailsService;
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserProfileDetailsServiceImpl userProfileDetailsService, UserServiceImpl userService) {
        this.userProfileDetailsService = userProfileDetailsService;
        this.userService = userService;
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

    @GetMapping("/getPointsByUserId/{userId}")
    public ResponseEntity<String> getPointsByUserId(@PathVariable Long userId) throws UserProfileDetailsNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(userProfileDetailsService.getPointsById(userId));
    }

    @PutMapping("/updateUsernameById/{userId}")
    public ResponseEntity<String> updateUsernameById(@PathVariable Long userId, @RequestBody NewUsernameBindingModel newUsernameBindingModel) throws UserNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUsernameById(userId, newUsernameBindingModel));
    }

    @PutMapping("/updatePasswordById/{userId}")
    public ResponseEntity<String> updatePasswordById(@PathVariable Long userId, @RequestBody NewPasswordBindingModel newPasswordBindingModel) throws UserNotFoundException, IncorrectPasswordException {

        return ResponseEntity.status(HttpStatus.OK).body(userService.updatePasswordById(userId, newPasswordBindingModel));
    }
}
