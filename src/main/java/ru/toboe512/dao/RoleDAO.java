package ru.toboe512.dao;

import ru.toboe512.models.Role;

import java.util.List;

public interface RoleDAO {

    Role findRoleById(Long id);

    void add(Role role);

    List<Role> listRoles();

    void delete(Role role);

    void update(Role role);

    Role getRole(Long id);
}
