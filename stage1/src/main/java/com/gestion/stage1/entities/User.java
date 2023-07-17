package com.gestion.stage1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class User {
    @Id @GeneratedValue(generator = "uuid2")
    private UUID IDUser;
    private String first_name;
    private String last_name;
    private String email;
    private Integer phone_number;
    private Boolean activation;

    public UUID getIDUser() {
        return IDUser;
    }

    public void setIDUser(UUID IDUser) {
        this.IDUser = IDUser;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public Boolean getActivation() {
        return activation;
    }

    public void setActivation(Boolean activation) {
        this.activation = activation;
    }

    public User(String first_name, String last_name, String email, Integer phone_number, Boolean activation) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.activation = activation;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "IDUser=" + IDUser +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                ", activation=" + activation +
                '}';
    }
}
