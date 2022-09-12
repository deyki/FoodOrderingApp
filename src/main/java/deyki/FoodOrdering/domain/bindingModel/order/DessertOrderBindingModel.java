package deyki.FoodOrdering.domain.bindingModel.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DessertOrderBindingModel {

    private String deliveryAddress;
    private String dessert;
}
