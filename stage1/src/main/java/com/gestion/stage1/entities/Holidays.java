package com.gestion.stage1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Holidays {
    @Id @GeneratedValue(generator = "uuid2")
    private UUID IDHolidays;
    private Integer day;
    private Integer month;
    private Integer year;
    private String label;

    public UUID getIDHolidays() {
        return IDHolidays;
    }

    public void setIDHolidays(UUID IDHolidays) {
        this.IDHolidays = IDHolidays;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Holidays(Integer day, Integer month, Integer year, String label) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.label = label;
    }

    public Holidays() {
        super();
    }

    @Override
    public String toString() {
        return "Holidays{" +
                "IDHolidays=" + IDHolidays +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", label='" + label + '\'' +
                '}';
    }
}
