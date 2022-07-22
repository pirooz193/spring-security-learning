package com.mycompany.onlineexam.web.rest;

import com.mycompany.onlineexam.domain.Admin;
import com.mycompany.onlineexam.service.AdminService;
import com.mycompany.onlineexam.web.errors.UnAuthorizedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/admin")
public class AdminResource {
    private final Logger logger = LogManager.getLogger(AdminResource.class);

    private final AdminService adminService;

    public AdminResource(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create-new-admin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        logger.info("Request to create admin :{}", admin);
        Admin createdAdmin = adminService.createNewAdmin(admin);
        return ResponseEntity.created(URI.create("/create-new-admin")).body(createdAdmin);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteAdmin(@RequestParam String adminUsername) {
        logger.info("Request to delete admin by username :{}", adminUsername);
        adminService.deleteAdminByUsername(adminUsername);
        return ResponseEntity.ok().build();
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
