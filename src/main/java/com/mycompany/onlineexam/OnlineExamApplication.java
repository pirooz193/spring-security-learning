package com.mycompany.onlineexam;

import com.mycompany.onlineexam.domain.Admin;
import com.mycompany.onlineexam.domain.Role;
import com.mycompany.onlineexam.service.AdminService;
import com.mycompany.onlineexam.service.MasterService;
import com.mycompany.onlineexam.service.StudentService;
import com.mycompany.onlineexam.service.UserService;
import com.mycompany.onlineexam.service.dto.MasterDTO;
import com.mycompany.onlineexam.service.dto.StudentDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class OnlineExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineExamApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, StudentService studentService, MasterService masterService,
                          AdminService adminService) {
        return args -> {
//            userService.saveRole(new Role("ROLE_STUDENT"));
//            userService.saveRole(new Role("ROLE_MASTER"));
//            userService.saveRole(new Role("ROLE_ADMIN"));
//
//
//            studentService.createStudent(new StudentDTO(null, "pirooz123", "123", null, "09118249965"));
//            masterService.createMaster(new MasterDTO(null, "master", "123", null, "09118249966"));
//            adminService.saveAdmin(new Admin( "admin", "123", new ArrayList<>(), "admin-code"));


//            userService.addRoleToUser("pirooz123", "ROLE_STUDENT");
//            userService.addRoleToUser("master", "ROLE_MASTER");
//            userService.addRoleToUser("admin", "ROLE_STUDENT");
//            userService.addRoleToUser("admin", "ROLE_MASTER");
//            userService.addRoleToUser("admin", "ROLE_ADMIN");
        };
    }
}
