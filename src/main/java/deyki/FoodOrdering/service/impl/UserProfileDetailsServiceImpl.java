package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.EmailBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.PhoneNumberBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.UpdateDetailsBindingModel;
import deyki.FoodOrdering.domain.bindingModel.userProfileDetails.UserProfileDetailsBindingModel;
import deyki.FoodOrdering.domain.entity.User;
import deyki.FoodOrdering.domain.entity.UserProfileDetails;
import deyki.FoodOrdering.domain.responseModel.userProfileDetails.UserProfileDetailsResponseModel;
import deyki.FoodOrdering.error.UserNotFoundException;
import deyki.FoodOrdering.error.UserProfileDetailsNotFoundException;
import deyki.FoodOrdering.repository.UserProfileDetailsRepository;
import deyki.FoodOrdering.repository.UserRepository;
import deyki.FoodOrdering.service.UserProfileDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileDetailsServiceImpl implements UserProfileDetailsService {

    private final UserProfileDetailsRepository userProfileDetailsRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserProfileDetailsServiceImpl(UserProfileDetailsRepository userProfileDetailsRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.userProfileDetailsRepository = userProfileDetailsRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createUserProfileDetails(UserProfileDetailsBindingModel userProfileDetailsBindingModel) throws UserNotFoundException {

        String username = userProfileDetailsBindingModel.getUsername();

        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("User %s not found!", username)));

        UserProfileDetails userProfileDetails = modelMapper.map(userProfileDetailsBindingModel, UserProfileDetails.class);
        userProfileDetails.setUser(user);
        userProfileDetails.setPoints(0);

        user.setUserProfileDetails(userProfileDetails);

        userRepository.save(user);
        userProfileDetailsRepository.save(userProfileDetails);
    }

    @Override
    public UserProfileDetailsResponseModel getUserProfileDetailsByEmail(EmailBindingModel emailBindingModel) throws UserProfileDetailsNotFoundException {

        String email = emailBindingModel.getEmail();

        UserProfileDetails userProfileDetails = userProfileDetailsRepository.findByEmail(email)
                .orElseThrow(() -> new UserProfileDetailsNotFoundException("User profile details not found!"));

        String username = userProfileDetails.getUser().getUsername();

        UserProfileDetailsResponseModel responseModel = modelMapper.map(userProfileDetails, UserProfileDetailsResponseModel.class);
        responseModel.setUsername(username);

        return responseModel;
    }

    @Override
    public UserProfileDetailsResponseModel getUserProfileDetailsByPhoneNumber(PhoneNumberBindingModel phoneNumberBindingModel) throws UserProfileDetailsNotFoundException {

        Integer phoneNumber = phoneNumberBindingModel.getPhoneNumber();

        UserProfileDetails userProfileDetails = userProfileDetailsRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UserProfileDetailsNotFoundException("User profile details not found!"));

        String username = userProfileDetails.getUser().getUsername();

        UserProfileDetailsResponseModel responseModel = modelMapper.map(userProfileDetails, UserProfileDetailsResponseModel.class);
        responseModel.setUsername(username);

        return responseModel;
    }

    @Override
    public void updateUserProfileDetailsById(Long userDetailsId, UpdateDetailsBindingModel updateDetailsBindingModel) throws UserProfileDetailsNotFoundException {

        UserProfileDetails userProfileDetails = userProfileDetailsRepository
                .findById(userDetailsId)
                .orElseThrow(() -> new UserProfileDetailsNotFoundException("User details not found!"));

        String firstName = userProfileDetails.getFirstName();
        String lastName = userProfileDetails.getLastName();
        Integer phoneNumber = userProfileDetails.getPhoneNumber();
        String email = userProfileDetails.getEmail();

        userProfileDetails.setFirstName(firstName);
        userProfileDetails.setLastName(lastName);
        userProfileDetails.setPhoneNumber(phoneNumber);
        userProfileDetails.setEmail(email);

        userProfileDetailsRepository.save(userProfileDetails);
    }
}
