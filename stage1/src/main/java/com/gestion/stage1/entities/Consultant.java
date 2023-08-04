package com.gestion.stage1.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class    Consultant extends User {


    private String service_name;
    private String mission_description;

    @OneToOne
    private Prestataire prestataire;

    @OneToMany(mappedBy = "consultant",cascade = CascadeType.ALL)
    private List<Timesheet> timesheets;

    @OneToMany(mappedBy = "consultant", cascade = CascadeType.ALL)
    private List<InfoAccess> infoAccessList;



    public Prestataire getPrestataire() {
        return prestataire;
    }

    public void setPrestataire(Prestataire prestataire) {
        this.prestataire = prestataire;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getMission_description() {
        return mission_description;
    }

    public void setMission_description(String mission_description) {
        this.mission_description = mission_description;
    }

    public Consultant(String first_name, String last_name, String email, String phone_number, Boolean activation, Prestataire prestataire, String service_name, String mission_description) {
        super(first_name, last_name, email, phone_number, activation);
        this.prestataire = prestataire;
        this.service_name = service_name;
        this.mission_description = mission_description;
    }

    public Consultant() {
        super();
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "prestataire=" + prestataire +
                ", service_name='" + service_name + '\'' +
                ", mission_description='" + mission_description + '\'' +
                '}';
    }
}
