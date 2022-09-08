package deyki.FoodOrdering.domain.responseModel.salad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaladResponseModel {

    private String salad;
    private Integer quantity;
}
