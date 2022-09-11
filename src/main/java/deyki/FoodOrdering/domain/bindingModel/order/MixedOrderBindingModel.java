package deyki.FoodOrdering.domain.bindingModel.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MixedOrderBindingModel {

    private String deliveryAddress;
    private String drink;
    private String pizza;
    private String mainDish;
    private String salad;
    private String dessert;
}
