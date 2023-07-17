package com.gestion.stage1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class InfoAccess {
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    private Timesheet timesheet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }

    public InfoAccess(LocalDate date, LocalTime time, Timesheet timesheet) {
        this.date = date;
        this.time = time;
        this.timesheet = timesheet;
    }

    public InfoAccess() {
        super();
    }

    @Override
    public String toString() {
        return "InfoAccess{" +
                "date=" + date +
                ", time=" + time +
                ", timesheet=" + timesheet +
                '}';
    }
}
