package com.mycompany.onlineexam.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "admin_code", nullable = false, unique = true)
    private String adminCode;

    public Admin() {
    }

    public Admin(Long id, String username, String password, String adminCode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.adminCode = adminCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id.equals(admin.id) &&
                username.equals(admin.username) &&
                password.equals(admin.password) &&
                adminCode.equals(admin.adminCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, adminCode);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adminCode='" + adminCode + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }
}
