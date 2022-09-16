package deyki.FoodOrdering.domain.entity;

import deyki.FoodOrdering.domain.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Long orderId;

    @Column(name = "order_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private OrderType orderType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "paid")
    private Boolean paid;

    @Column(name = "name")
    private String drink;

    @Column(name = "pizza")
    private String pizza;

    @Column(name = "main_dish")
    private String mainDish;

    @Column(name = "salad")
    private String salad;

    @Column(name = "dessert")
    private String dessert;
}
