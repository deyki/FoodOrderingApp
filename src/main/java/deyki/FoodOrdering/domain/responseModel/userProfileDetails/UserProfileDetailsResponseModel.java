package deyki.FoodOrdering.domain.responseModel.userProfileDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDetailsResponseModel {

    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private Integer points;
    private String username;
}
