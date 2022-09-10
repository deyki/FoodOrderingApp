package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.salad.SaladBindingModel;
import deyki.FoodOrdering.domain.entity.Salad;
import deyki.FoodOrdering.domain.responseModel.salad.SaladResponseModel;
import deyki.FoodOrdering.error.MenuNotInitializedException;
import deyki.FoodOrdering.error.SaladNotFoundException;
import deyki.FoodOrdering.repository.SaladRepository;
import deyki.FoodOrdering.service.impl.SaladServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salad")
public class SaladController {

    private final SaladServiceImpl saladService;

    public SaladController(SaladServiceImpl saladService) {
        this.saladService = saladService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createSalad(@RequestBody SaladBindingModel saladBindingModel) throws MenuNotInitializedException {

        saladService.createSalad(saladBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Salad created!");
    }

    @GetMapping("/getAllSalads")
    public ResponseEntity<List<SaladResponseModel>> getAllSalads() {

        return ResponseEntity.status(HttpStatus.OK).body(saladService.getAllSalads());
    }

    @GetMapping("/getSaladById/{saladId}")
    public ResponseEntity<SaladResponseModel> getSaladById(@PathVariable Long saladId) throws SaladNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(saladService.getSaladById(saladId));
    }

    @GetMapping("/getSaladByName/{saladName}")
    public ResponseEntity<SaladResponseModel> getSaladByName(@PathVariable String saladName) throws SaladNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(saladService.getSaladByName(saladName));
    }

    @PutMapping("/updateQuantity")
    public ResponseEntity<String> updateQuantity(@RequestBody QuantityBindingModel quantityBindingModel) throws SaladNotFoundException {

        saladService.updateQuantity(quantityBindingModel);

        return ResponseEntity.status(HttpStatus.OK).body("Quantity updated successfully!");
    }

    @DeleteMapping("/deleteSaladById/{saladId}")
    public ResponseEntity<String> deleteSaladById(@PathVariable Long saladId) throws SaladNotFoundException {

        saladService.deleteSaladById(saladId);

        return ResponseEntity.status(HttpStatus.OK).body("Salad deleted successfully!");
    }

    @DeleteMapping("/deleteSaladByName/{saladName}")
    public ResponseEntity<String> deleteSaladByName(@PathVariable String saladName) throws SaladNotFoundException {

        saladService.deleteSaladByName(saladName);

        return ResponseEntity.status(HttpStatus.OK).body("Salad deleted successfully!");
    }
}
