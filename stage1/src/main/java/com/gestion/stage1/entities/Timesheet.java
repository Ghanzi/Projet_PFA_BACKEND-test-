package com.gestion.stage1.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Timesheet {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID IDTimesheet;
    @ManyToOne()
    private Consultant consultant;

    @OneToMany(mappedBy = "timesheet",cascade = CascadeType.ALL)
    private List<InfoAccess> infoAccesses;

    @OneToOne
    private Validation validation;

    public UUID getIDTimesheet() {
        return IDTimesheet;
    }

    public void setIDTimesheet(UUID IDTimesheet) {
        this.IDTimesheet = IDTimesheet;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public List<InfoAccess> getInfoAccesses() {
        return infoAccesses;
    }

    public void setInfoAccesses(List<InfoAccess> infoAccesses) {
        this.infoAccesses = infoAccesses;
    }

    public Timesheet(Consultant consultant, List<InfoAccess> infoAccesses) {
        this.consultant = consultant;
        this.infoAccesses = infoAccesses;
    }

    public Timesheet() {
        super();
    }

    @Override
    public String toString() {
        return "Timesheet{" +
                "consultant=" + consultant +
                ", infoAccesses=" + infoAccesses +
                '}';
    }
}
