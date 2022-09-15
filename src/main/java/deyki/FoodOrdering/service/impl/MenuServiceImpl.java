package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.entity.Menu;
import deyki.FoodOrdering.domain.responseModel.menu.MenuResponseModel;
import deyki.FoodOrdering.error.MenuAlreadyInitializedException;
import deyki.FoodOrdering.error.MenuNotInitializedException;
import deyki.FoodOrdering.repository.MenuRepository;
import deyki.FoodOrdering.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    public MenuServiceImpl(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initMenu() throws MenuAlreadyInitializedException {

        if (menuRepository.count() == 0) {

            Menu mainMenu = new Menu();
            mainMenu.setName("Main menu");

            menuRepository.save(mainMenu);
        } else {

            throw new MenuAlreadyInitializedException("Menu is already initialized!");
        }
    }

    @Override
    public MenuResponseModel getMenu() throws MenuNotInitializedException {

        Menu menu = menuRepository
                .findByName("Main menu")
                .orElseThrow(() -> new MenuNotInitializedException("Main menu is not initialized!"));

        return modelMapper.map(menu, MenuResponseModel.class);
    }

    @Override
    public String deleteMenu() throws MenuNotInitializedException {

        Menu menu = menuRepository
                .findByName("Main menu")
                .orElseThrow(() -> new MenuNotInitializedException("Main menu is not initialized!"));

        menuRepository.delete(menu);

        return "Main menu is deleted!";
    }
}


