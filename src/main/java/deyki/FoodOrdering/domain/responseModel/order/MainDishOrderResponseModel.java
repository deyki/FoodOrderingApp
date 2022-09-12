package deyki.FoodOrdering.domain.responseModel.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainDishOrderResponseModel {

    private String deliveryAddress;
    private String mainDish;
}
