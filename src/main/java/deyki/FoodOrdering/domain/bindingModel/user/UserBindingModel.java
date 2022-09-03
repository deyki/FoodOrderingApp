package deyki.FoodOrdering.domain.bindingModel.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBindingModel {

    private String username;
    private String password;
}
