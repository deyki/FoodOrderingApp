package deyki.FoodOrdering.domain.bindingModel.pizza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaBindingModel {

    private String pizza;
    private Integer quantity;
}
