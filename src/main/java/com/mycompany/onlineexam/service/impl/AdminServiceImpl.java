package com.mycompany.onlineexam.service.impl;

import com.mycompany.onlineexam.domain.Admin;
import com.mycompany.onlineexam.repository.AdminRepository;
import com.mycompany.onlineexam.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    private final Logger logger = LogManager.getLogger(AdminServiceImpl.class);

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
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

}
