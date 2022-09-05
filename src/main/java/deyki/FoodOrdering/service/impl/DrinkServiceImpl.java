package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.drink.DrinkBindingModel;
import deyki.FoodOrdering.domain.entity.Drink;
import deyki.FoodOrdering.domain.responseModel.drink.DrinkResponseModel;
import deyki.FoodOrdering.error.DrinkNotFoundException;
import deyki.FoodOrdering.repository.DrinkRepository;
import deyki.FoodOrdering.service.DrinkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository, ModelMapper modelMapper) {
        this.drinkRepository = drinkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createDrink(DrinkBindingModel drinkBindingModel) {

        Drink drink = modelMapper.map(drinkBindingModel, Drink.class);

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
}