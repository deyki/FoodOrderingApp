package deyki.FoodOrdering.domain.responseModel.menu;

import deyki.FoodOrdering.domain.responseModel.dessert.DessertResponseModel;
import deyki.FoodOrdering.domain.responseModel.drink.DrinkResponseModel;
import deyki.FoodOrdering.domain.responseModel.mainDish.MainDishResponseModel;
import deyki.FoodOrdering.domain.responseModel.pizza.PizzaResponseModel;
import deyki.FoodOrdering.domain.responseModel.salad.SaladResponseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuResponseModel {

    private List<DrinkResponseModel> drinks;
    private List<PizzaResponseModel> pizzas;
    private List<MainDishResponseModel> mainDishes;
    private List<SaladResponseModel> salads;
    private List<DessertResponseModel> desserts;
}
