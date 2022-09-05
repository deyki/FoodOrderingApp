package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.repository.DrinkRepository;
import deyki.FoodOrdering.repository.MenuRepository;
import deyki.FoodOrdering.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final DrinkRepository drinkRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, DrinkRepository drinkRepository) {
        this.menuRepository = menuRepository;
        this.drinkRepository = drinkRepository;
    }
}


