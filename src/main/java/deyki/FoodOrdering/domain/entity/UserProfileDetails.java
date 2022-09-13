package deyki.FoodOrdering.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_profile_details")
public class UserProfileDetails {

    @Id
    @SequenceGenerator(name = "user_details_sequence", sequenceName = "user_details_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_details_sequence")
    private Long userDetailsId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private Integer phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "points")
    private Integer points;

    @OneToOne(mappedBy = "userProfileDetails")
    @JsonIgnore
    private User user;
}
