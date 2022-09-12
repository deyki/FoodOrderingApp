package deyki.FoodOrdering.domain.responseModel.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkOrderResponseModel {

    private String deliveryAddress;
    private String drink;
}
