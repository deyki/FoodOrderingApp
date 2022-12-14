package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.dessert.DessertBindingModel;
import deyki.FoodOrdering.domain.responseModel.dessert.DessertResponseModel;
import deyki.FoodOrdering.error.DessertNotFoundException;
import deyki.FoodOrdering.error.MenuNotInitializedException;
import deyki.FoodOrdering.service.impl.DessertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dessert")
public class DessertController {

    private final DessertServiceImpl dessertService;

    @Autowired
    public DessertController(DessertServiceImpl dessertService) {
        this.dessertService = dessertService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDessert(@RequestBody DessertBindingModel dessertBindingModel) throws MenuNotInitializedException {

        dessertService.createDessert(dessertBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Dessert created!");
    }

    @GetMapping("/listOfDesserts")
    public ResponseEntity<List<DessertResponseModel>> getListOfDesserts() {

        return ResponseEntity.status(HttpStatus.OK).body(dessertService.getAllDesserts());
    }

    @GetMapping("/getDessertById/{dessertId}")
    public ResponseEntity<DessertResponseModel> getDessertById(@PathVariable Long dessertId) throws DessertNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(dessertService.getDessertById(dessertId));
    }

    @GetMapping("/getDessertByName/{dessertName}")
    public ResponseEntity<DessertResponseModel> getDessertByName(@PathVariable String dessertName) throws DessertNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(dessertService.getDessertByName(dessertName));
    }

    @PutMapping("/updateQuantity")
    public ResponseEntity<String> updateQuantity(@RequestBody QuantityBindingModel quantityBindingModel) throws DessertNotFoundException {

        dessertService.updateQuantity(quantityBindingModel);

        return ResponseEntity.status(HttpStatus.OK).body("Quantity updated successfully!");
    }

    @DeleteMapping("/deleteDessertById/{dessertId}")
    public ResponseEntity<String> deleteDessertById(@PathVariable Long dessertId) throws DessertNotFoundException {

        dessertService.deleteDessertById(dessertId);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Dessert with id: %d deleted!", dessertId));
    }

    @DeleteMapping("/deleteDessertByName/{dessertName}")
    public ResponseEntity<String> deleteDessertByName(@PathVariable String dessertName) throws DessertNotFoundException {

        dessertService.deleteDessertByName(dessertName);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Dessert %s deleted!", dessertName));
    }
}
