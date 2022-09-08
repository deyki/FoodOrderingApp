package deyki.FoodOrdering.domain.bindingModel.drink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkBindingModel {

    private String drink;
    private Integer quantity;
}
