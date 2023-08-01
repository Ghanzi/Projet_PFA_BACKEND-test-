package com.gestion.stage1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Holidays {
    @Id @GeneratedValue(generator = "uuid2")
    private UUID IDHolidays;

    private LocalDate date;
    private String label;

    public UUID getIDHolidays() {
        return IDHolidays;
    }

    public void setIDHolidays(UUID IDHolidays) {
        this.IDHolidays = IDHolidays;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Holidays(UUID IDHolidays, LocalDate date, String label) {
        this.IDHolidays = IDHolidays;
        this.date = date;
        this.label = label;
    }

    public Holidays() {
        super();
    }

    @Override
    public String toString() {
        return "Holidays{" +
                "IDHolidays=" + IDHolidays +
                ", date=" + date +
                ", label='" + label + '\'' +
                '}';
    }
}
