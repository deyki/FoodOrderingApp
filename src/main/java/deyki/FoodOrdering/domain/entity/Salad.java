package deyki.FoodOrdering.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salads")
public class Salad {

    @Id
    @SequenceGenerator(name = "salad_sequence", sequenceName = "salad_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salad_sequence")
    private Long saladId;

    @Column(name = "salad")
    private String salad;

    @Column(name = "quantity")
    private Integer quantity;
}
