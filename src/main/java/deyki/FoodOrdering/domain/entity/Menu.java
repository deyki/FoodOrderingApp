package deyki.FoodOrdering.domain.entity;

import deyki.FoodOrdering.controller.PizzaController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Menu")
public class Menu {

    @Id
    @SequenceGenerator(name = "menu_sequence", sequenceName = "menu_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_sequence")
    private Long menuId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", referencedColumnName = "menuId")
    private List<Drink> drinks;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", referencedColumnName = "menuId")
    private List<Pizza> pizzas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", referencedColumnName = "menuId")
    private List<MainDish> mainDishes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", referencedColumnName = "menuId")
    private List<Dessert> desserts;
}
