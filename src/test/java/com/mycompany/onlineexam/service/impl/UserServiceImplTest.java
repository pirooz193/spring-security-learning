package com.mycompany.onlineexam.service.impl;

import com.mycompany.onlineexam.domain.Role;
import com.mycompany.onlineexam.domain.User;
import com.mycompany.onlineexam.repository.RoleRepository;
import com.mycompany.onlineexam.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class UserServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRole() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);
        Role roleStudent = new Role();
        roleStudent.setName("ROLE_STUDENT");
        roleRepository.save(roleStudent);
        Role roleMaster = new Role();
        roleMaster.setName("ROLE_MASTER");
        roleRepository.save(roleMaster);
    }

    @Test
    void save() {
        User adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword("admin");
        Optional<Role> role_admin = roleRepository.findRoleByName("ROLE_ADMIN");
        adminUser.setRoles(Collections.singletonList(role_admin.get()));
        userRepository.save(adminUser);

        User masterUser = new User();
        masterUser.setUsername("master");
        masterUser.setPassword("master");
        Optional<Role> roleMaster = roleRepository.findRoleByName("ROLE_MASTER");
        masterUser.setRoles(Collections.singletonList(roleMaster.get()));
        userRepository.save(masterUser);

        User studentUser = new User();
        studentUser.setUsername("student");
        studentUser.setPassword("student");
        Optional<Role> roleStudent = roleRepository.findRoleByName("ROLE_STUDENT");
        studentUser.setRoles(Collections.singletonList(roleStudent.get()));
        userRepository.save(studentUser);
    }

    @Test
    void saveDuplicateUser() {
        User studentUser = new User();
        studentUser.setUsername("student");
        studentUser.setPassword("test");
        Assertions.assertThrows(Exception.class, () -> userRepository.save(studentUser));
    }

    @Test
    void findUserByUsername() {
        Assertions.assertThrows(Exception.class, () -> userRepository.findUserByUsername("username").get());
        Assertions.assertNotNull(userRepository.findUserByUsername("test"));
    }

    @Test
    void addRoleToUser() {
        User user = userRepository.findUserByUsername("admin").get();
        Role role = roleRepository.findRoleByName("ROLE_STUDENT").get();
        user.setRoles(Collections.singletonList(role));
        User savedUser = userRepository.save(user);
        Assertions.assertTrue(savedUser.getRoles().stream()
                .anyMatch(role1 -> role.getName().equals("ROLE_STUDENT")));
    }

    @Test
    void getAllUsers() {
        Assertions.assertNotNull(userRepository.findAll());
    }

    @Test
    void getToken() throws Exception {
        mockMvc.perform(post("/api/get-token").with(csrf())
                        .param("username" , "test")
                        .param("password" , "test"))
                .andExpect(status().isUnauthorized());
        mockMvc.perform(post("/api/get-token").with(csrf())
                        .param("username" , "master")
                        .param("password" , "09118249966"))
                .andExpect(status().isOk());
    }
}