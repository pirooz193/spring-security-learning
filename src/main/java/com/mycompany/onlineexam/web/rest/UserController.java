package com.mycompany.onlineexam.web.rest;

import com.mycompany.onlineexam.domain.Role;
import com.mycompany.onlineexam.domain.RoleToUserForm;
import com.mycompany.onlineexam.domain.User;
import com.mycompany.onlineexam.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger logger = LogManager.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        logger.info("Request to create user :{}", user);
        User savedUser = userService.save(user);
        return ResponseEntity.created(new URI("/api/create/user")).body(user);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Request to get all users");
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/create/role")
    public ResponseEntity<Role> createRole(@RequestBody Role role) throws URISyntaxException {
        logger.info("Request to create role :{}", role);
        Role savedRole = userService.saveRole(role);
        return ResponseEntity.created(new URI("/api/create/role")).body(savedRole);
    }

    @PutMapping("/add-role")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        logger.info("Request ro add role :{} to  user :{}", form.getRoleName(), form.getUsername());
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
