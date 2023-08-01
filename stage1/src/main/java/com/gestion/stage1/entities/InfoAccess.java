package com.gestion.stage1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
public class InfoAccess {
    @Id @GeneratedValue(generator = "uuid2")
    private UUID IDInfoAccess;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    private Timesheet timesheet;

    @ManyToOne
    private Consultant consultant;



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

    public UUID getIDInfoAccess() {
        return IDInfoAccess;
    }

    public void setIDInfoAccess(UUID IDInfoAccess) {
        this.IDInfoAccess = IDInfoAccess;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
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

    public void setId(UUID id) {
        this.IDInfoAccess= id;
    }

    public UUID getId() {
        return IDInfoAccess;
    }
}
