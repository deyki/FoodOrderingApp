package deyki.FoodOrdering.service.impl;

import deyki.FoodOrdering.domain.entity.Role;
import deyki.FoodOrdering.repository.RoleRepository;
import deyki.FoodOrdering.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seedRolesInDb() {

        Role roleAdmin = new Role();
        roleAdmin.setAuthority("ADMIN");

        Role roleUser = new Role();
        roleUser.setAuthority("USER");

        roleRepository.saveAndFlush(roleAdmin);
        roleRepository.saveAndFlush(roleUser);
    }

    @Override
    public Set<Role> findAllRoles() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    public Role findByAuthority(String authority) {
        return roleRepository
                .findByAuthority(authority)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Role %s not found!", authority)));
    }
}
