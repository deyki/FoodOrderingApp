package deyki.FoodOrdering.service;

import deyki.FoodOrdering.domain.entity.Role;

import java.util.Set;

public interface RoleService {

    void seedRolesInDb();

    Set<Role> findAllRoles();

    Role findByAuthority(String authority);
}
