package deyki.FoodOrdering.domain.bindingModel.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainDishOrderBindingModel {

    private String deliveryAddress;
    private String mainDish;
}
