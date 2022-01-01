package com.mycompany.onlineexam.auth;

import com.mycompany.onlineexam.domain.Admin;
import com.mycompany.onlineexam.domain.Master;
import com.mycompany.onlineexam.domain.Student;
import com.mycompany.onlineexam.service.AdminService;
import com.mycompany.onlineexam.service.MasterService;
import com.mycompany.onlineexam.service.StudentService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService  implements UserDetailsService {

    private final AdminService adminService;
    private final StudentService studentService;
    private final MasterService masterService;

    public ApplicationUserService(AdminService adminService, StudentService studentService, MasterService masterService) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.masterService = masterService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminService.getAdminByUsername(username);
        Student student = studentService.getStudentByUsername(username);
        Master master = masterService.getMasterByUsername(username);
        return null;
    }
}
