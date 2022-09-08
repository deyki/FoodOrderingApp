package deyki.FoodOrdering.domain.responseModel.pizza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaResponseModel {

    private String pizza;
    private Integer quantity;
}
