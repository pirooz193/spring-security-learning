package com.mycompany.onlineexam.web.rest;

import com.mycompany.onlineexam.domain.Role;
import com.mycompany.onlineexam.domain.User;
import com.mycompany.onlineexam.service.impl.TestUtil;
import com.mycompany.onlineexam.web.model.TokenModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createUser() throws Exception {
        String token = getToken("admin", "123");
        User user = new User();
        user.setUsername("pirooz");
        user.setPassword("123");
        user.setRoles(new ArrayList<>());

        mockMvc.perform(post("/api/admin/create/user").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(user))
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isCreated());
    }

    @Test
    void getAllUsers() throws Exception {
        String token = getToken("admin", "123");
        mockMvc.perform(get("/api/admin/get-all-users")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    public String getToken(String username, String password) {
        MultiValueMap<String, String> adminUser = new LinkedMultiValueMap<>();
        adminUser.add("username", username);
        adminUser.add("password",password);
        TokenModel tokenModel = WebClient.create()
                .post()
                .uri("localhost:8080/api/get-token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(adminUser))
                .retrieve()
                .bodyToMono(TokenModel.class)
                .block();
        return tokenModel.getAccessToken();
    }

    @Test
    void createRole() throws Exception {
        String token = getToken("admin", "123");
        Role role = new Role("ROLE_SUPER_USER");
        mockMvc.perform(post("/api/admin/create/role").with(csrf())
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(role)))
                .andExpect(status().isCreated());
    }

    @Test
    void addRoleToUser() {
    }

    @Test
    void getToken() throws Exception {
        mockMvc.perform(post("/api/get-token").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("username", "master")
                        .param("password", "09118249966"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/get-token").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("username", "test")
                        .param("password", "test"))
                .andExpect(status().isUnauthorized());
    }
}