package deyki.FoodOrdering.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pizzas")
public class Pizza {

    @Id
    @SequenceGenerator(name = "pizza_sequence", sequenceName = "pizza_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizza_sequence")
    private Long pizzaId;

    @Column(name = "pizza")
    private String pizza;

    @Column(name = "quantity")
    private Integer quantity;
}
