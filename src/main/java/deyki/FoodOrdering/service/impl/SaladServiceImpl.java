package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.bindingModel.quantity.QuantityBindingModel;
import deyki.FoodOrdering.domain.bindingModel.salad.SaladBindingModel;
import deyki.FoodOrdering.domain.entity.Salad;
import deyki.FoodOrdering.domain.responseModel.salad.SaladResponseModel;
import deyki.FoodOrdering.error.SaladNotFoundException;
import deyki.FoodOrdering.repository.SaladRepository;
import deyki.FoodOrdering.service.SaladService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaladServiceImpl implements SaladService {

    private final SaladRepository saladRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SaladServiceImpl(SaladRepository saladRepository, ModelMapper modelMapper) {
        this.saladRepository = saladRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createSalad(SaladBindingModel saladBindingModel) {

        Salad salad = modelMapper.map(saladBindingModel, Salad.class);

        saladRepository.save(salad);
    }

    @Override
    public List<SaladResponseModel> getAllSalads() {

        return saladRepository
                .findAll()
                .stream()
                .map(salad -> modelMapper.map(salad, SaladResponseModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public SaladResponseModel getSaladById(Long saladId) throws SaladNotFoundException {

        return saladRepository
                .findById(saladId)
                .map(salad -> modelMapper.map(salad, SaladResponseModel.class))
                .orElseThrow(() -> new SaladNotFoundException(String.format("Salad with id: %d not found!", saladId)));
    }

    @Override
    public SaladResponseModel getSaladByName(String saladName) throws SaladNotFoundException {

        return saladRepository
                .findByName(saladName)
                .map(salad -> modelMapper.map(salad, SaladResponseModel.class))
                .orElseThrow(() -> new SaladNotFoundException(String.format("Salad %s not found!", saladName)));
    }

    @Override
    public void updateQuantity(QuantityBindingModel quantityBindingModel) throws SaladNotFoundException {

        Salad salad = saladRepository
                .findById(quantityBindingModel.getProductId())
                .orElseThrow(() -> new SaladNotFoundException(String.format("Salad with id: %d not found!", quantityBindingModel.getProductId())));

        salad.setQuantity(quantityBindingModel.getQuantity());

        saladRepository.save(salad);
    }

    @Override
    public void deleteSaladById(Long saladId) throws SaladNotFoundException {

        Salad salad = saladRepository
                .findById(saladId)
                .orElseThrow(() -> new SaladNotFoundException(String.format("Salad with id: %d not found!", saladId)));

        saladRepository.delete(salad);
    }

    @Override
    public void deleteSaladByName(String saladName) throws SaladNotFoundException {

        Salad salad = saladRepository
                .findByName(saladName)
                .orElseThrow(() -> new SaladNotFoundException(String.format("Salad %s not found!", saladName)));

        saladRepository.delete(salad);
    }
}
