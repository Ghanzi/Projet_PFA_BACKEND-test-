package com.gestion.stage1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Prestataire {
    @Id @GeneratedValue(generator = "uuid2")
    private UUID IDPrestataire;
    private String first_name;
    private String last_name;
    private String email;
    private String contract;

    public UUID getIDPrestataire() {
        return IDPrestataire;
    }

    public void setIDPrestataire(UUID IDPrestataire) {
        this.IDPrestataire = IDPrestataire;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Prestataire(String first_name, String last_name, String email, String contract) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.contract = contract;
    }

    public Prestataire() {
        super();
    }

    @Override
    public String toString() {
        return "Prestataire{" +
                "IDPrestataire=" + IDPrestataire +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", contract='" + contract + '\'' +
                '}';
    }
}
