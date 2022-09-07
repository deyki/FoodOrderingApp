package deyki.FoodOrdering.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "main_dishes")
public class MainDish {

    @Id
    @SequenceGenerator(name = "main_dish_sequence", sequenceName = "main_dish_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "main_dish_sequence")
    private Long mainDishId;

    @Column(name = "main_dish")
    private String mainDish;
}
