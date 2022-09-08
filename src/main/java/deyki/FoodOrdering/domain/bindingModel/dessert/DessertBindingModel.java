package deyki.FoodOrdering.domain.bindingModel.dessert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DessertBindingModel {

    private String dessert;
    private Integer quantity;
}
