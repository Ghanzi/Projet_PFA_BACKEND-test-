package com.gestion.stage1.entities;

import jakarta.persistence.Entity;

@Entity
public class Admin_Validators extends User {
    private Integer employee_number;

    public Integer getEmployee_number() {
        return employee_number;
    }

    public void setEmployee_number(Integer employee_number) {
        this.employee_number = employee_number;
    }

    public Admin_Validators(String first_name, String last_name, String email, Integer phone_number, Boolean activation, Integer employee_number) {
        super(first_name, last_name, email, phone_number, activation);
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
