package com.mycompany.onlineexam.domain;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "master_table")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "master_code", nullable = false, unique = true)
    private String masterCode;
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    public Master() {
    }

    public Master(Long id, String username, String password, String masterCode, Set<Course> courses) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.masterCode = masterCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return id.equals(master.id) &&
                username.equals(master.username) &&
                password.equals(master.password) &&
                masterCode.equals(master.masterCode) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, masterCode);
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", masterCode='" + masterCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
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

    public String getMasterCode() {
        return masterCode;
    }

    public void setMasterCode(String masterCode) {
        this.masterCode = masterCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
