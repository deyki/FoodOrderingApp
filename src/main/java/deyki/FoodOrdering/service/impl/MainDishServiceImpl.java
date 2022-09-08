package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.mainDish.MainDishBindingModel;
import deyki.FoodOrdering.domain.entity.MainDish;
import deyki.FoodOrdering.domain.responseModel.mainDish.MainDishResponseModel;
import deyki.FoodOrdering.error.MainDishNotFoundException;
import deyki.FoodOrdering.repository.MainDishRepository;
import deyki.FoodOrdering.service.MainDishService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainDishServiceImpl implements MainDishService {

    private final MainDishRepository mainDishRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MainDishServiceImpl(MainDishRepository mainDishRepository, ModelMapper modelMapper) {
        this.mainDishRepository = mainDishRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createMainDish(MainDishBindingModel mainDishBindingModel) {

        MainDish mainDish = modelMapper.map(mainDishBindingModel, MainDish.class);

        mainDishRepository.save(mainDish);
    }

    @Override
    public List<MainDishResponseModel> getAllMainDishes() {

        return mainDishRepository
                .findAll()
                .stream()
                .map(mainDish -> modelMapper.map(mainDish, MainDishResponseModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public MainDishResponseModel getMainDishById(Long mainDishId) throws MainDishNotFoundException {

        return mainDishRepository
                .findById(mainDishId)
                .map(mainDish -> modelMapper.map(mainDish, MainDishResponseModel.class))
                .orElseThrow(() -> new MainDishNotFoundException(String.format("Main dish with id: %d not found!", mainDishId)));
    }

    @Override
    public MainDishResponseModel getMainDishByName(MainDishBindingModel mainDishBindingModel) throws MainDishNotFoundException {

        return mainDishRepository
                .findByName(mainDishBindingModel.getMainDish())
                .map(mainDish -> modelMapper.map(mainDish, MainDishResponseModel.class))
                .orElseThrow(() -> new MainDishNotFoundException(String.format("Main dish %s not found!", mainDishBindingModel.getMainDish())));
    }

    @Override
    public void updateQuantity(QuantityBindingModel quantityBindingModel) throws MainDishNotFoundException {

        MainDish mainDish = mainDishRepository
                .findById(quantityBindingModel.getProductId())
                .orElseThrow(() -> new MainDishNotFoundException(String.format("Main dish with id: %d not found!", quantityBindingModel.getProductId())));

        mainDish.setQuantity(quantityBindingModel.getQuantity());

        mainDishRepository.save(mainDish);
    }

    @Override
    public void deleteMainDishById(Long mainDishId) throws MainDishNotFoundException {

        MainDish mainDish = mainDishRepository
                .findById(mainDishId)
                .orElseThrow(() -> new MainDishNotFoundException(String.format("Main dish with id: %d not found!", mainDishId)));

        mainDishRepository.delete(mainDish);
    }

    @Override
    public void deleteMainDishByName(MainDishBindingModel mainDishBindingModel) throws MainDishNotFoundException {

        MainDish mainDish = mainDishRepository
                .findByName(mainDishBindingModel.getMainDish())
                .orElseThrow(() -> new MainDishNotFoundException(String.format("Main dish %s not found!", mainDishBindingModel.getMainDish())));

        mainDishRepository.delete(mainDish);
    }
}
