package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.pizza.PizzaBindingModel;
import deyki.FoodOrdering.domain.responseModel.pizza.PizzaResponseModel;
import deyki.FoodOrdering.error.PizzaNotFoundException;
import deyki.FoodOrdering.service.impl.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    private final PizzaServiceImpl pizzaService;

    @Autowired
    public PizzaController(PizzaServiceImpl pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPizza(@RequestBody PizzaBindingModel pizzaBindingModel) {

        pizzaService.createPizza(pizzaBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Pizza created!");
    }

    @GetMapping("/getPizzaById/{pizzaId}")
    public ResponseEntity<PizzaResponseModel> getPizzaById(@PathVariable Long pizzaId) throws PizzaNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(pizzaService.getPizzaById(pizzaId));
    }

    @GetMapping("/getPizzaByName/{pizzaName}")
    public ResponseEntity<PizzaResponseModel> getPizzaByName(@PathVariable String pizzaName) throws PizzaNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(pizzaService.getPizzaByName(pizzaName));
    }

    @PutMapping("/updateQuantity")
    public ResponseEntity<String> updateQuantity(@RequestBody QuantityBindingModel quantityBindingModel) throws PizzaNotFoundException {

        pizzaService.updateQuantity(quantityBindingModel);

        return ResponseEntity.status(HttpStatus.OK).body("Quantity updated successfully!");
    }

    @DeleteMapping("/deletePizzaById/{pizzaId}")
    public ResponseEntity<String> deletePizzaById(@PathVariable Long pizzaId) throws PizzaNotFoundException {

        pizzaService.deletePizzaById(pizzaId);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Pizza with id: %d deleted!", pizzaId));
    }

    @DeleteMapping("/deletePizzaByName/{pizzaName}")
    public ResponseEntity<String> deletePizzaByName(@PathVariable String pizzaName) throws PizzaNotFoundException {

        pizzaService.deletePizzaByName(pizzaName);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Pizza %s deleted!", pizzaName));
    }
}
