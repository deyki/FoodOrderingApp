package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.dessert.DessertBindingModel;
import deyki.FoodOrdering.domain.entity.Dessert;
import deyki.FoodOrdering.domain.entity.Menu;
import deyki.FoodOrdering.domain.responseModel.dessert.DessertResponseModel;
import deyki.FoodOrdering.error.DessertNotFoundException;
import deyki.FoodOrdering.error.MenuNotInitializedException;
import deyki.FoodOrdering.repository.DessertRepository;
import deyki.FoodOrdering.repository.MenuRepository;
import deyki.FoodOrdering.service.DessertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DessertServiceImpl implements DessertService {

    private final DessertRepository dessertRepository;
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DessertServiceImpl(DessertRepository dessertRepository, MenuRepository menuRepository, ModelMapper modelMapper) {
        this.dessertRepository = dessertRepository;
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createDessert(DessertBindingModel dessertBindingModel) throws MenuNotInitializedException {

        Dessert dessert = modelMapper.map(dessertBindingModel, Dessert.class);

        Menu menu = menuRepository
                .findById(1L)
                .orElseThrow(() -> new MenuNotInitializedException("Menu is not initialized!"));

        menu.getDesserts().add(dessert);

        dessertRepository.save(dessert);
    }

    @Override
    public List<DessertResponseModel> getAllDesserts() {

        return dessertRepository
                .findAll()
                .stream()
                .map(dessert -> modelMapper.map(dessert, DessertResponseModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public DessertResponseModel getDessertById(Long dessertId) throws DessertNotFoundException {

        return dessertRepository
                .findById(dessertId)
                .map(dessert -> modelMapper.map(dessert, DessertResponseModel.class))
                .orElseThrow(() -> new DessertNotFoundException(String.format("Dessert with id: %d not found!", dessertId)));
    }

    @Override
    public DessertResponseModel getDessertByName(String dessertName) throws DessertNotFoundException {

        return dessertRepository
                .findByName(dessertName)
                .map(dessert -> modelMapper.map(dessert, DessertResponseModel.class))
                .orElseThrow(() -> new DessertNotFoundException(String.format("Dessert %s not found!", dessertName)));
    }

    @Override
    public void updateQuantity(QuantityBindingModel quantityBindingModel) throws DessertNotFoundException {

        Dessert dessert = dessertRepository
                .findById(quantityBindingModel.getProductId())
                .orElseThrow(() -> new DessertNotFoundException(String.format("Dessert with id: %d not found!", quantityBindingModel.getProductId())));

        dessert.setQuantity(quantityBindingModel.getQuantity());

        dessertRepository.save(dessert);
    }

    @Override
    public void deleteDessertById(Long dessertId) throws DessertNotFoundException {

        Dessert dessert = dessertRepository
                .findById(dessertId)
                .orElseThrow(() -> new DessertNotFoundException(String.format("Dessert with id: %d not found!", dessertId)));

        dessertRepository.delete(dessert);
    }

    @Override
    public void deleteDessertByName(String dessertName) throws DessertNotFoundException {

        Dessert dessert = dessertRepository
                .findByName(dessertName)
                .orElseThrow(() -> new DessertNotFoundException(String.format("Dessert %s not found!", dessertName)));

        dessertRepository.delete(dessert);
    }
}
