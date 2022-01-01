package com.mycompany.onlineexam.service.impl;

import com.mycompany.onlineexam.domain.Admin;
import com.mycompany.onlineexam.repository.AdminRepository;
import com.mycompany.onlineexam.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private final Logger logger = LogManager.getLogger(AdminServiceImpl.class);

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
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
