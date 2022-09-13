package deyki.FoodOrdering.domain.bindingModel.userProfileDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDetailsBindingModel {

    private String username;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
}
