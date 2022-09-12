package deyki.FoodOrdering.domain.responseModel.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MixedOrderResponseModel {

    private String deliveryAddress;
    private String drink;
    private String pizza;
    private String mainDish;
    private String salad;
    private String dessert;
}
