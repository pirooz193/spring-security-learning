package com.mycompany.onlineexam.domain;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "master_table")
public class Master extends User{

    @Column(name = "master_code", nullable = false, unique = true)
    private String masterCode;
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    public Master() {
    }

    public Master(String username, String password, String masterCode, Set<Course> courses) {
        super.setUsername(username);
        super.setPassword(password);
        this.masterCode = masterCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return masterCode.equals(master.masterCode) && phoneNumber.equals(master.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterCode, phoneNumber);
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterCode='" + masterCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
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
