package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.bindingModel.drink.DrinkBindingModel;
import deyki.FoodOrdering.domain.responseModel.drink.DrinkResponseModel;
import deyki.FoodOrdering.error.DrinkNotFoundException;
import deyki.FoodOrdering.service.impl.DrinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drink")
public class DrinkController {

    private final DrinkServiceImpl drinkService;

    @Autowired
    public DrinkController(DrinkServiceImpl drinkService) {
        this.drinkService = drinkService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDrink(@RequestBody DrinkBindingModel drinkBindingModel) {

        drinkService.createDrink(drinkBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Drink added!");
    }

    @GetMapping("/drinks")
    public ResponseEntity<List<DrinkResponseModel>> getDrinks() {

        return ResponseEntity.status(HttpStatus.OK).body(drinkService.getAllDrinks());
    }


    @GetMapping("/getDrinkById/{drinkId}")
    public ResponseEntity<DrinkResponseModel> getDrinkById(@PathVariable Long drinkId) throws DrinkNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(drinkService.getDrinkById(drinkId));
    }
}
