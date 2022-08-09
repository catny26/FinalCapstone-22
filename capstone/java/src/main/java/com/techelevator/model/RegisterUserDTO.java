package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class RegisterUserDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;
    @NotEmpty(message = "Please select a role for this user.")
    private String role;
    @NotEmpty(message = "Please enter your full name.")
    private String fullName;
    private String typeOfDoctor;


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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTypeOfDoctor() {
        return typeOfDoctor;
    }

    public void setTypeOfDoctor(String typeOfDoctor) {
        this.typeOfDoctor = typeOfDoctor;
    }
}
