package deyki.FoodOrdering.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "desserts")
public class Dessert {

    @Id
    @SequenceGenerator(name = "dessert_sequence", sequenceName = "dessert_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dessert_sequence")
    private Long dessertId;

    @Column(name = "dessert")
    private String dessert;

    @Column(name = "quantity")
    private Integer quantity;
}
