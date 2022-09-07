package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.bindingModel.mainDish.MainDishBindingModel;
import deyki.FoodOrdering.domain.responseModel.mainDish.MainDishResponseModel;
import deyki.FoodOrdering.error.MainDishNotFoundException;
import deyki.FoodOrdering.service.impl.MainDishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mainDish")
public class MainDishController {

    private final MainDishServiceImpl mainDishService;

    @Autowired
    public MainDishController(MainDishServiceImpl mainDishService) {
        this.mainDishService = mainDishService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createMainDish(@RequestBody MainDishBindingModel mainDishBindingModel) {

        mainDishService.createMainDish(mainDishBindingModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Main dish created!");
    }

    @GetMapping("/AllMainDishes")
    public ResponseEntity<List<MainDishResponseModel>> getAllMainDishes() {

        return ResponseEntity.status(HttpStatus.OK).body(mainDishService.getAllMainDishes());
    }

    @GetMapping("/getMainDish/{mainDishId}")
    public ResponseEntity<MainDishResponseModel> getMainDishById(@PathVariable Long mainDishId) throws MainDishNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(mainDishService.getMainDishById(mainDishId));
    }

    @GetMapping("/getMainDishByName")
    public ResponseEntity<MainDishResponseModel> getMainDishByName(@RequestBody MainDishBindingModel mainDishBindingModel) throws MainDishNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(mainDishService.getMainDishByName(mainDishBindingModel));
    }

    @DeleteMapping("/deleteMainDishById/{mainDishId}")
    public ResponseEntity<String> deleteMainDishById(@PathVariable Long mainDishId) throws MainDishNotFoundException {

        mainDishService.deleteMainDishById(mainDishId);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Main dish with id: %d deleted!", mainDishId));
    }

    @DeleteMapping("/deleteMainDishByName")
    public ResponseEntity<String> deleteMainDishByName(@RequestBody MainDishBindingModel mainDishBindingModel) throws MainDishNotFoundException {

        mainDishService.deleteMainDishByName(mainDishBindingModel);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Main dish %s deleted!", mainDishBindingModel.getMainDish()));
    }
}
