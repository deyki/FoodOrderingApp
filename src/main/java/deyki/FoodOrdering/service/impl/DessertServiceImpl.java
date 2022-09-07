package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.dessert.DessertBindingModel;
import deyki.FoodOrdering.domain.entity.Dessert;
import deyki.FoodOrdering.domain.responseModel.dessert.DessertResponseModel;
import deyki.FoodOrdering.error.DessertNotFoundException;
import deyki.FoodOrdering.repository.DessertRepository;
import deyki.FoodOrdering.service.DessertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DessertServiceImpl implements DessertService {

    private final DessertRepository dessertRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DessertServiceImpl(DessertRepository dessertRepository, ModelMapper modelMapper) {
        this.dessertRepository = dessertRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createDessert(DessertBindingModel dessertBindingModel) {

        Dessert dessert = modelMapper.map(dessertBindingModel, Dessert.class);

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
    public DessertResponseModel getDessertByName(DessertBindingModel dessertBindingModel) throws DessertNotFoundException {

        return dessertRepository
                .findByName(dessertBindingModel.getDessert())
                .map(dessert -> modelMapper.map(dessert, DessertResponseModel.class))
                .orElseThrow(() -> new DessertNotFoundException(String.format("Dessert %s not found!", dessertBindingModel.getDessert())));
    }

    @Override
    public void deleteDessertById(Long dessertId) throws DessertNotFoundException {

        Dessert dessert = dessertRepository
                .findById(dessertId)
                .orElseThrow(() -> new DessertNotFoundException(String.format("Dessert with id: %d not found!", dessertId)));

        dessertRepository.delete(dessert);
    }

    @Override
    public void deleteDessertByName(DessertBindingModel dessertBindingModel) throws DessertNotFoundException {

        Dessert dessert = dessertRepository
                .findByName(dessertBindingModel.getDessert())
                .orElseThrow(() -> new DessertNotFoundException(String.format("Dessert %s not found!", dessertBindingModel.getDessert())));

        dessertRepository.delete(dessert);
    }
}
