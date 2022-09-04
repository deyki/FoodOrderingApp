package deyki.FoodOrdering.service.impl;

import com.google.common.collect.Sets;
import deyki.FoodOrdering.domain.bindingModel.user.UserBindingModel;
import deyki.FoodOrdering.domain.entity.User;
import deyki.FoodOrdering.domain.responseModel.user.LoginResponseModel;
import deyki.FoodOrdering.error.UserNotFoundException;
import deyki.FoodOrdering.repository.UserRepository;
import deyki.FoodOrdering.security.JWTUtil;
import deyki.FoodOrdering.service.RoleService;
import deyki.FoodOrdering.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;
    private final JWTUtil jwtUtil;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper, JWTUtil jwtUtil, RoleService roleService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
        this.jwtUtil = jwtUtil;
        this.roleService = roleService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username: %s not found!", username)));
    }


    @Override
    public void register(UserBindingModel userBindingModel) {

        userRepository.findByUsername(userBindingModel.getUsername()).ifPresent(user -> {
                    throw new EntityExistsException(String.format("User with username: %s already exist!", userBindingModel.getUsername()));
                });

        User user = modelMapper.map(userBindingModel, User.class);

        if (userRepository.count() == 0) {

            roleService.seedRolesInDb();

            user.setAuthorities(Sets.newHashSet(roleService.findByAuthority("ADMIN")));
        } else {

            user.setAuthorities(Sets.newHashSet(roleService.findByAuthority("USER")));
        }

        user.setPassword(bCryptPasswordEncoder.encode(userBindingModel.getPassword()));

        userRepository.save(user);
    }

    @Override
    public LoginResponseModel login(UserBindingModel userBindingModel) throws UserNotFoundException {

        User user = userRepository.findByUsername(userBindingModel.getUsername())
                .orElseThrow(() -> new UserNotFoundException(String.format("User %s not found!", userBindingModel.getUsername())));

        String token = jwtUtil.generateToken(user.getUsername());

        return new LoginResponseModel(token);
    }
}
