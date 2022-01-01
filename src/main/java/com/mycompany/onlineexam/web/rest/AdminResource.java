package com.mycompany.onlineexam.web.rest;

import com.mycompany.onlineexam.domain.Admin;
import com.mycompany.onlineexam.service.AdminService;
import com.mycompany.onlineexam.web.errors.UnAuthorizedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminResource {
    private final Logger logger = LogManager.getLogger(AdminResource.class);

    private final AdminService adminService;

    public AdminResource(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> loginAdmin(@RequestParam String username, @RequestParam String password) {
        logger.info("Request to login admin with username:{} , and password :{}", username, password);
        Admin admin = adminService.checkAdminLogin(username, password);
        if (admin == null) throw new UnAuthorizedException();
        logger.info("Login request response :{}", admin);
        return ResponseEntity.ok().body(admin);
    }

}
