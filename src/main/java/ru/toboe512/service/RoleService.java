package ru.toboe512.service;

import ru.toboe512.models.Role;
import ru.toboe512.models.User;

import java.util.List;

public interface RoleService {
    Role findRoleById(Long id);

    User setRolesByStrings(String[] roles, User user);

    void add(Role role);

    List<Role> listRoless();

    void delete(Role role);

    void update(Role role);

    Role getRole(Long id);
}
