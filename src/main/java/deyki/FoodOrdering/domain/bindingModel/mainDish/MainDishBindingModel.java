package deyki.FoodOrdering.domain.bindingModel.mainDish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainDishBindingModel {

    private String mainDish;
    private Integer quantity;
}
