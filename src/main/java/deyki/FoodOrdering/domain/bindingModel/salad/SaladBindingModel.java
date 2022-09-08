package deyki.FoodOrdering.domain.bindingModel.salad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaladBindingModel {

    private String salad;
    private Integer quantity;
}
