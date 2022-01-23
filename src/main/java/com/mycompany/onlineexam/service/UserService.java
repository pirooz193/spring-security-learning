package com.mycompany.onlineexam.service;

import com.mycompany.onlineexam.domain.Role;
import com.mycompany.onlineexam.domain.User;

import java.util.List;

public interface UserService {


    User findUserByUsername(String username);

    User save(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    List<User> getAllUsers();

    String getToken(String username, String password);
}
