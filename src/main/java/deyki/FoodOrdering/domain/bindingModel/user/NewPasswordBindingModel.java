package deyki.FoodOrdering.domain.bindingModel.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPasswordBindingModel {

    private String oldPassword;
    private String newPassword;
}
