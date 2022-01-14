package com.mycompany.onlineexam.service;

import com.mycompany.onlineexam.domain.Admin;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    Admin checkAdminLogin(String username, String password);

    Admin getAdminByUsername(String username);
}
