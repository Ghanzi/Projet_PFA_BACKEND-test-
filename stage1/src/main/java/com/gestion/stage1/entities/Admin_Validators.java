package com.gestion.stage1.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Admin_Validators extends User {

    @GeneratedValue(generator = "uuid2")
    private UUID employee_number;

    @OneToMany(mappedBy = "validateur", cascade = CascadeType.ALL)
    private List<Validation> validations = new ArrayList<>();



    public Admin_Validators(String first_name, String last_name, String email, String phone_number, Boolean activation, UUID employee_number) {
        super(first_name, last_name, email, phone_number, activation);
        this.employee_number = employee_number;
    }

    public UUID getEmployee_number() {
        return employee_number;
    }

    public void setEmployee_number(UUID employee_number) {
        this.employee_number = employee_number;
    }


    public Admin_Validators() {
        super();
    }

    @Override
    public String toString() {
        return "Admin_Validators{" +
                "employee_number=" + employee_number +
                '}';
    }
}
