package com.gestion.stage1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.UUID;

@Entity
public class Validation {
    @Id @GeneratedValue(generator = "uuid2")
    private UUID IDValidation;
    private LocalDate validation_date;
    private Boolean state;

    @ManyToOne
    private Admin_Validators validateur;

    @OneToOne(mappedBy = "validation")
    private Timesheet timesheet;



    public UUID getIDValidation() {
        return IDValidation;
    }

    public void setIDValidation(UUID IDValidation) {
        this.IDValidation = IDValidation;
    }

    public LocalDate getValidation_date() {
        return validation_date;
    }

    public void setValidation_date(LocalDate validation_date) {
        this.validation_date = validation_date;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Validation(LocalDate validation_date, Boolean state) {
        this.validation_date = validation_date;
        this.state = state;
    }

    public Validation() {
        super();
    }

    @Override
    public String toString() {
        return "Validation{" +
                "IDValidation=" + IDValidation +
                ", validation_date=" + validation_date +
                ", state=" + state +
                '}';
    }
}
