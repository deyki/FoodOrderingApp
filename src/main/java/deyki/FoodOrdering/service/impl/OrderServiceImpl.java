package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.order.*;
import deyki.FoodOrdering.domain.entity.Order;
import deyki.FoodOrdering.domain.entity.User;
import deyki.FoodOrdering.domain.enums.OrderType;
import deyki.FoodOrdering.error.UserNotFoundException;
import deyki.FoodOrdering.repository.OrderRepository;
import deyki.FoodOrdering.repository.UserRepository;
import deyki.FoodOrdering.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void fullOrder(Long userId, FullOrderBindingModel fullOrderBindingModel) throws UserNotFoundException {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %d not found!", userId)));

        Order order = modelMapper.map(fullOrderBindingModel, Order.class);
        order.setUser(user);
        order.setActive(true);
        order.setOrderType(OrderType.FullOrder);

        orderRepository.save(order);
    }

    @Override
    public void mixedOrder(Long userId, MixedOrderBindingModel mixedOrderBindingModel) throws UserNotFoundException {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %d not found!", userId)));

        Order order = modelMapper.map(mixedOrderBindingModel, Order.class);
        order.setActive(true);
        order.setUser(user);
        order.setOrderType(OrderType.MixedOrder);

        orderRepository.save(order);
    }

    @Override
    public void drinkOrder(Long userId, DrinkOrderBindingModel drinkOrderBindingModel) throws UserNotFoundException {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %d not found!", userId)));

        Order order = modelMapper.map(drinkOrderBindingModel, Order.class);
        order.setUser(user);
        order.setActive(true);
        order.setOrderType(OrderType.DrinkOrder);

        orderRepository.save(order);
    }

    @Override
    public void pizzaOrder(Long userId, PizzaOrderBindingModel pizzaOrderBindingModel) throws UserNotFoundException {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %d not found!", userId)));

        Order order = modelMapper.map(pizzaOrderBindingModel, Order.class);
        order.setActive(true);
        order.setUser(user);
        order.setOrderType(OrderType.PizzaOrder);

        orderRepository.save(order);
    }

    @Override
    public void mainDishOrder(Long userId, MainDishOrderBindingModel mainDishOrderBindingModel) throws UserNotFoundException {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %d not found!", userId)));

        Order order = modelMapper.map(mainDishOrderBindingModel, Order.class);
        order.setActive(true);
        order.setUser(user);
        order.setOrderType(OrderType.MainDishOrder);

        orderRepository.save(order);
    }

    @Override
    public void saladOrder(Long userId, SaladOrderBindingModel saladOrderBindingModel) throws UserNotFoundException {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %d not found!", userId)));

        Order order = modelMapper.map(saladOrderBindingModel, Order.class);
        order.setActive(true);
        order.setUser(user);
        order.setOrderType(OrderType.SaladOrder);

        orderRepository.save(order);
    }

    @Override
    public void dessertOrder(Long userId, DessertOrderBindingModel dessertOrderBindingModel) throws UserNotFoundException {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %d not found!", userId)));

        Order order = modelMapper.map(dessertOrderBindingModel, Order.class);
        order.setActive(true);
        order.setUser(user);
        order.setOrderType(OrderType.DessertOrder);

        orderRepository.save(order);
    }
}
