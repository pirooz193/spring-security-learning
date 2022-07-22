package com.mycompany.onlineexam.repository;

import com.mycompany.onlineexam.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findAdminByUsernameAndPassword(String username, String password);

    void deleteAdminByUsername(String username);

    Admin findAdminByUsername(String username);
}
