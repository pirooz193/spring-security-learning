package com.mycompany.onlineexam.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin")
public class Admin extends User{

    @Column(name = "admin_code", nullable = false, unique = true)
    private String adminCode;

    public Admin() {
    }

    public Admin( String username, String password, String adminCode) {
        super.setUsername(username);
        super.setPassword(password);
        this.adminCode = adminCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return adminCode.equals(admin.adminCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminCode);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminCode='" + adminCode + '\'' +
                '}';
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }
}
