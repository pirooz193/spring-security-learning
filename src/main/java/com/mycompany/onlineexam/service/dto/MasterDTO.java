package com.mycompany.onlineexam.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.onlineexam.domain.Role;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MasterDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("master_code")
    private String masterCode;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("roles")
    private List<Role> roles = new ArrayList<>();

    public MasterDTO(Long id, String username, String password, String masterCode, String phoneNumber, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.masterCode = masterCode;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public MasterDTO(Long id, String username, String password, String masterCode, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.masterCode = masterCode;
        this.phoneNumber = phoneNumber;
    }

    public MasterDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterDTO masterDTO = (MasterDTO) o;
        return id.equals(masterDTO.id) && username.equals(masterDTO.username) && password.equals(masterDTO.password) && masterCode.equals(masterDTO.masterCode) && phoneNumber.equals(masterDTO.phoneNumber) && roles.equals(masterDTO.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, masterCode, phoneNumber, roles);
    }

    @Override
    public String toString() {
        return "MasterDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", masterCode='" + masterCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roles=" + roles +
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
