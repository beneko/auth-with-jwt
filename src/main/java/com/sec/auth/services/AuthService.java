package com.sec.auth.services;

import com.sec.auth.entities.Role;
import com.sec.auth.entities.User;

import java.util.List;

public interface AuthService {
    User addUser(User user);
    Role addRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUserByUsername(String username);
    List<User> getUsers();
}
