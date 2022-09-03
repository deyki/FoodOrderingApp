package deyki.FoodOrdering.domain.responseModel.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseModel {

    private String JWToken;
}
