package deyki.FoodOrdering.repository;

import deyki.FoodOrdering.domain.entity.UserProfileDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileDetailsRepository extends JpaRepository<UserProfileDetails, Long> {

    @Query("SELECT u FROM UserProfileDetails u WHERE u.email = ?1")
    Optional<UserProfileDetails> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserProfileDetails u WHERE u.phoneNumber = ?1")
    Optional<UserProfileDetails> findByPhoneNumber(@Param("phoneNumber") Integer phoneNumber);

    @Query("SELECT u FROM UserProfileDetails u WHERE u.user.userId = ?1")
    Optional<UserProfileDetails> findByUserId(@Param("userId") Long userId);
}
