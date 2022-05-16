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

}
