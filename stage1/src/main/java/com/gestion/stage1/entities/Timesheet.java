package com.gestion.stage1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Timesheet {
    @ManyToOne
    private Consultant consultant;
    @OneToMany
    private List<InfoAccess> infoAccesses;

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
