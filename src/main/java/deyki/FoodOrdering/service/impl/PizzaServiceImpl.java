package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.pizza.PizzaBindingModel;
import deyki.FoodOrdering.domain.entity.Menu;
import deyki.FoodOrdering.domain.entity.Pizza;
import deyki.FoodOrdering.domain.responseModel.pizza.PizzaResponseModel;
import deyki.FoodOrdering.error.MenuNotInitializedException;
import deyki.FoodOrdering.error.PizzaNotFoundException;
import deyki.FoodOrdering.repository.MenuRepository;
import deyki.FoodOrdering.repository.PizzaRepository;
import deyki.FoodOrdering.service.PizzaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository, MenuRepository menuRepository, ModelMapper modelMapper) {
        this.pizzaRepository = pizzaRepository;
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createPizza(PizzaBindingModel pizzaBindingModel) throws MenuNotInitializedException {

        Pizza pizza = modelMapper.map(pizzaBindingModel, Pizza.class);

        Menu menu = menuRepository
                .findById(1L)
                .orElseThrow(() -> new MenuNotInitializedException("Menu is not initialized!"));

        menu.getPizzas().add(pizza);

        pizzaRepository.save(pizza);
    }

    @Override
    public PizzaResponseModel getPizzaById(Long pizzaId) throws PizzaNotFoundException {

        return pizzaRepository
                .findById(pizzaId)
                .map(pizza -> modelMapper.map(pizza, PizzaResponseModel.class))
                .orElseThrow(() -> new PizzaNotFoundException(String.format("Pizza with id: %d not found!", pizzaId)));
    }

    @Override
    public PizzaResponseModel getPizzaByName(String pizzaName) throws PizzaNotFoundException {

        return pizzaRepository
                .findByName(pizzaName)
                .map(pizza -> modelMapper.map(pizza, PizzaResponseModel.class))
                .orElseThrow(() -> new PizzaNotFoundException(String.format("Pizza %s not found!", pizzaName)));
    }

    @Override
    public void updateQuantity(QuantityBindingModel quantityBindingModel) throws PizzaNotFoundException {

        Pizza pizza = pizzaRepository
                .findById(quantityBindingModel.getProductId())
                .orElseThrow(() -> new PizzaNotFoundException(String.format("Pizza with id: %d not found!", quantityBindingModel.getProductId())));

        pizza.setQuantity(quantityBindingModel.getQuantity());

        pizzaRepository.save(pizza);
    }

    @Override
    public void deletePizzaById(Long pizzaId) throws PizzaNotFoundException {

        Pizza pizza = pizzaRepository
                .findById(pizzaId)
                .orElseThrow(() -> new PizzaNotFoundException(String.format("Pizza with id: %d not found!", pizzaId)));

        pizzaRepository.deleteById(pizza.getPizzaId());
    }

    @Override
    public void deletePizzaByName(String pizzaName) throws PizzaNotFoundException {

        Pizza pizza = pizzaRepository
                .findByName(pizzaName)
                .orElseThrow(() -> new PizzaNotFoundException(String.format("Pizza %s not found!", pizzaName)));

        pizzaRepository.delete(pizza);
    }
}
