package com.mycompany.onlineexam.service.impl;

import com.mycompany.onlineexam.domain.Admin;
import com.mycompany.onlineexam.domain.constants.Constants;
import com.mycompany.onlineexam.repository.AdminRepository;
import com.mycompany.onlineexam.service.AdminService;
import com.mycompany.onlineexam.web.model.ApiUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.mycompany.onlineexam.config.enumuration.ApplicationUserRoles.*;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Value(value = "${application.constants.admin-code-number}")
    private Integer NUMBER_OF_ADMIN_CODE;
    private final Logger logger = LogManager.getLogger(AdminServiceImpl.class);

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userService;

    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder, UserServiceImpl userService) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        logger.info("request to save admin :{}", admin);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    @Override
    public Admin checkAdminLogin(String username, String password) {
        logger.debug("Request to check admin login with username:{} and password :{}", username, password);
        return adminRepository.findAdminByUsernameAndPassword(username, password);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminRepository.findAdminByUsername(username);
    }

    @Override
    public Admin createNewAdmin(Admin admin) {
        logger.debug("Request to create new  admin in service layer  admin :{}", admin);
        Admin newAdmin = new Admin();
        newAdmin.setUsername(admin.getUsername());
        newAdmin.setAdminCode(ApiUtil.generateRandomCode(Constants.ADMIN, NUMBER_OF_ADMIN_CODE));
        newAdmin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Admin savedAdmin = adminRepository.save(newAdmin);
        userService.addRoleToUser(admin.getUsername(), ROLE_ADMIN.name());
        userService.addRoleToUser(admin.getUsername(), ROLE_STUDENT.name());
        userService.addRoleToUser(admin.getUsername(), ROLE_MASTER.name());
        return savedAdmin;
    }

    @Override
    public void deleteAdminByUsername(String adminUsername) {
        logger.debug("Request ro delete admin by username:{} in service layer .", adminUsername);
        adminRepository.deleteAdminByUsername(adminUsername);
    }

}
