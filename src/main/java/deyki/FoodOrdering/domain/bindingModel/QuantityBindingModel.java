package deyki.FoodOrdering.domain.bindingModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantityBindingModel {

    private Long productId;
    private Integer quantity;
}
