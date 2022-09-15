package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.bindingModel.order.*;
import deyki.FoodOrdering.domain.entity.Dessert;
import deyki.FoodOrdering.domain.entity.Order;
import deyki.FoodOrdering.domain.responseModel.order.*;
import deyki.FoodOrdering.domain.responseModel.user.UserResponseModel;
import deyki.FoodOrdering.error.OrderNotFoundException;
import deyki.FoodOrdering.error.UserNotFoundException;
import deyki.FoodOrdering.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/fullOrder/{userId}")
    public ResponseEntity<String> fullOrder(@PathVariable Long userId, @RequestBody FullOrderBindingModel fullOrderBindingModel) throws UserNotFoundException {

        orderService.fullOrder(userId, fullOrderBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order successfully created!");
    }

    @PostMapping("/mixedOrder/{userId}")
    public ResponseEntity<String> mixedOrder(@PathVariable Long userId, @RequestBody MixedOrderBindingModel mixedOrderBindingModel) throws UserNotFoundException {

        orderService.mixedOrder(userId, mixedOrderBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order successfully created!");
    }

    @PostMapping("/drinkOrder/{userId}")
    public ResponseEntity<String> drinkOrder(@PathVariable Long userId, @RequestBody DrinkOrderBindingModel drinkOrderBindingModel) throws UserNotFoundException {

        orderService.drinkOrder(userId, drinkOrderBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order successfully created!");
    }

    @PostMapping("/pizzaOrder/{userId}")
    public ResponseEntity<String> pizzaOrder(@PathVariable Long userId, @RequestBody PizzaOrderBindingModel pizzaOrderBindingModel) throws UserNotFoundException {

        orderService.pizzaOrder(userId, pizzaOrderBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order successfully created!");
    }

    @PostMapping("/mainDishOrder/{userId}")
    public ResponseEntity<String> mainDishOrder(@PathVariable Long userId, @RequestBody MainDishOrderBindingModel mainDishOrderBindingModel) throws UserNotFoundException {

        orderService.mainDishOrder(userId, mainDishOrderBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order successfully created!");
    }

    @PostMapping("/saladOrder/{userId}")
    public ResponseEntity<String> saladOrder(@PathVariable Long userId, @RequestBody SaladOrderBindingModel saladOrderBindingModel) throws UserNotFoundException {

        orderService.saladOrder(userId, saladOrderBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order successfully created!");
    }

    @PostMapping("/dessertOrder/{userId}")
    public ResponseEntity<String> dessertOrder(@PathVariable Long userId, @RequestBody DessertOrderBindingModel dessertOrderBindingModel) throws UserNotFoundException {

        orderService.dessertOrder(userId, dessertOrderBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order successfully created!");
    }

    @GetMapping("/active-fullOrders")
    public ResponseEntity<List<FullOrderResponseModel>> getListOfActiveFullOrders() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getListOfActiveFullOrders());
    }

    @GetMapping("/active-mixedOrders")
    public ResponseEntity<List<MixedOrderResponseModel>> getListOfActiveMixedOrders() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getListOfActiveMixedOrders());
    }

    @GetMapping("/active-drinkOrders")
    public ResponseEntity<List<DrinkOrderResponseModel>> getListOfActiveDrinkOrders() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getListOfActiveDrinkOrders());
    }

    @GetMapping("/active-pizzaOrders")
    public ResponseEntity<List<PizzaOrderResponseModel>> getListOfActivePizzaOrders() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getListOfActivePizzaOrders());
    }

    @GetMapping("/active-mainDishOrders")
    public ResponseEntity<List<MainDishOrderResponseModel>> getListOfActiveMainDishOrders() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getListOfActiveMainDishOrders());
    }

    @GetMapping("/active-saladOrders")
    public ResponseEntity<List<SaladOrderResponseModel>> getListOfActiveSaladOrders() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getListOfActiveSaladOrders());
    }

    @GetMapping("/active-dessertOrders")
    public ResponseEntity<List<DessertOrderResponseModel>> getListOfActiveDessertOrders() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getListOfActiveDessertOrders());
    }

    @GetMapping("/active-orders")
    public ResponseEntity<List<OrderResponseModel>> getActiveOrders() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getListOfActiveOrders());
    }

    @GetMapping("/nonActive-orders")
    public ResponseEntity<List<Order>> getListOfNonActiveOrders() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getListOfNonActiveOrders());
    }

    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) throws OrderNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(orderId));
    }

    @PutMapping("/updateActiveById/{orderId}")
    public ResponseEntity<String> updateActiveById(@PathVariable Long orderId) throws OrderNotFoundException {

        orderService.updateActiveById(orderId);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Order %d updated!", orderId));
    }

    @GetMapping("/getUserByOrderId/{orderId}")
    public ResponseEntity<UserResponseModel> getUserByOrderId(@PathVariable Long orderId) throws OrderNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getUserInfoByOrderId(orderId));
    }

    @DeleteMapping("/deleteById/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Long orderId) throws OrderNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrderById(orderId));
    }

    @GetMapping("/getDeliveryAddressById/{orderId}")
    public ResponseEntity<DeliveryAddressResponseModel> getDeliveryAddressById(@PathVariable Long orderId) throws OrderNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getDeliveryAddressByOrderId(orderId));
    }
}
