package ru.pinch.service.user;

import ru.pinch.entity.Role;
import ru.pinch.entity.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    List<User> getUsers();
    void deleteUser(String id);

    void addRole(Role role);
    Role getRoleByID(int id);
    void deleteRoleByID(int id);
}
