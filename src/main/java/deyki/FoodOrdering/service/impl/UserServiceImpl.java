package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.user.UserBindingModel;
import deyki.FoodOrdering.domain.responseModel.user.LoginResponseModel;
import deyki.FoodOrdering.repository.UserRepository;
import deyki.FoodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username: %s not found!", username)));
    }


    @Override
    public void register(UserBindingModel userBindingModel) {

    }

    @Override
    public LoginResponseModel login(UserBindingModel userBindingModel) {
        return null;
    }

}
