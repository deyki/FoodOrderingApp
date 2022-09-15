package deyki.FoodOrdering.controller;

import deyki.FoodOrdering.domain.responseModel.menu.MenuResponseModel;
import deyki.FoodOrdering.error.MenuAlreadyInitializedException;
import deyki.FoodOrdering.error.MenuNotInitializedException;
import deyki.FoodOrdering.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuServiceImpl menuService;

    @Autowired
    public MenuController(MenuServiceImpl menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/init")
    public ResponseEntity<String> initMenu() throws MenuAlreadyInitializedException {

        menuService.initMenu();

        return ResponseEntity.status(HttpStatus.OK).body("Menu initialized!");
    }

    @GetMapping("/getMenu")
    public ResponseEntity<MenuResponseModel> getMenu() throws MenuNotInitializedException {

        return ResponseEntity.status(HttpStatus.OK).body(menuService.getMenu());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMenu() throws MenuNotInitializedException {

        return ResponseEntity.status(HttpStatus.OK).body(menuService.deleteMenu());
    }
}
