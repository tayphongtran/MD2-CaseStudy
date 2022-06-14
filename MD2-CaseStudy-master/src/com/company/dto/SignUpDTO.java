package com.company.dto;

import java.util.Set;

public class SignUpDTO {
    private String name;
    private String username;
    private String password;
    private Set<String> strRole;

    public SignUpDTO() {
    }

    public SignUpDTO(String name, String username, String password, Set<String> strRole) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.strRole = strRole;
    }

    public SignUpDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<String> getStrRole() {
        return strRole;
    }

    public void setStrRole(Set<String> strRole) {
        this.strRole = strRole;
    }

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", strRole=" + strRole +
                '}';
    }
}
