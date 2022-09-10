package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.drink.DrinkBindingModel;
import deyki.FoodOrdering.domain.entity.Drink;
import deyki.FoodOrdering.domain.entity.Menu;
import deyki.FoodOrdering.domain.responseModel.drink.DrinkResponseModel;
import deyki.FoodOrdering.error.DrinkNotFoundException;
import deyki.FoodOrdering.error.MenuNotInitializedException;
import deyki.FoodOrdering.repository.DrinkRepository;
import deyki.FoodOrdering.repository.MenuRepository;
import deyki.FoodOrdering.service.DrinkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository, MenuRepository menuRepository, ModelMapper modelMapper) {
        this.drinkRepository = drinkRepository;
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createDrink(DrinkBindingModel drinkBindingModel) throws MenuNotInitializedException {

        Drink drink = modelMapper.map(drinkBindingModel, Drink.class);

        Menu menu = menuRepository
                .findById(1L)
                .orElseThrow(() -> new MenuNotInitializedException("Menu is not initialized!"));

        menu.getDrinks().add(drink);

        drinkRepository.save(drink);
    }

    @Override
    public List<DrinkResponseModel> getAllDrinks() {

        return drinkRepository
                .findAll()
                .stream()
                .map(drink -> modelMapper.map(drink, DrinkResponseModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public DrinkResponseModel getDrinkById(Long drinkId) throws DrinkNotFoundException {

        return drinkRepository
                .findById(drinkId)
                .map(drink -> modelMapper.map(drink, DrinkResponseModel.class))
                .orElseThrow(() -> new DrinkNotFoundException(String.format("Drink with id: %d not found!", drinkId)));
    }

    @Override
    public DrinkResponseModel getDrinkByName(String drinkName) throws DrinkNotFoundException {

        return drinkRepository
                .findByDrink(drinkName)
                .map(drink -> modelMapper.map(drink, DrinkResponseModel.class))
                .orElseThrow(() -> new DrinkNotFoundException(String.format("Drink %s not found!", drinkName)));
    }

    @Override
    public void updateQuantity(QuantityBindingModel quantityBindingModel) throws DrinkNotFoundException {

        Drink drink = drinkRepository
                .findById(quantityBindingModel.getProductId())
                .orElseThrow(() -> new DrinkNotFoundException(String.format("Drink with id: %d not found!", quantityBindingModel.getProductId())));

        drink.setQuantity(quantityBindingModel.getQuantity());

        drinkRepository.save(drink);
    }


    @Override
    public void deleteDrinkById(Long drinkId) throws DrinkNotFoundException {

        Drink drink = drinkRepository
                .findById(drinkId)
                .orElseThrow(() -> new DrinkNotFoundException(String.format("Drink with id: %d not found!", drinkId)));

        drinkRepository.deleteById(drink.getDrinkId());
    }

    @Override
    public void deleteDrinkByName(String drinkName) throws DrinkNotFoundException {

        Drink drink = drinkRepository
                .findByDrink(drinkName)
                .orElseThrow(() -> new DrinkNotFoundException(String.format("Drink %s not found!", drinkName)));

        drinkRepository.delete(drink);
    }
}
