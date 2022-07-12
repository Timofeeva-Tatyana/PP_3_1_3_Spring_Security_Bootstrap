package ru.kata.PP_3_1_3_Spring_Security_Bootstrap.dao;

import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    void saveRole(Role role);

    Role findRoleById(Long id);

    Role findRoleByName(String name);

}
