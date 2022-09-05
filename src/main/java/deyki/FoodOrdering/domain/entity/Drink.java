package deyki.FoodOrdering.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drinks")
public class Drink {

    @Id
    @SequenceGenerator(name = "drink_sequence", sequenceName = "drink_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drink_sequence")
    private Long drinkId;

    @Column(name = "drink")
    private String drink;
}
