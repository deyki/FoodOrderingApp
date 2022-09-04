package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.bindingModel.user.UserBindingModel;
import deyki.FoodOrdering.domain.responseModel.user.LoginResponseModel;
import deyki.FoodOrdering.error.UserNotFoundException;
import deyki.FoodOrdering.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(UserServiceImpl userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserBindingModel userBindingModel) {

        userService.register(userBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Registration completed!");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseModel> login(@RequestBody UserBindingModel userBindingModel) throws UserNotFoundException {

        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userBindingModel.getUsername(), userBindingModel.getPassword()));

        return ResponseEntity.status(HttpStatus.OK).body(userService.login(userBindingModel));
    }
}
