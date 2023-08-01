package com.gestion.stage1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Prestataire {
    @Id @GeneratedValue(generator = "uuid2")
    private UUID IDPrestataire;

    private String name;

    private String email;
    private String contract;


    public Prestataire( String name, String email, String contract) {

        this.name = name;
        this.email = email;
        this.contract = contract;
    }

    public UUID getIDPrestataire() {
        return IDPrestataire;
    }

    public void setIDPrestataire(UUID IDPrestataire) {
        this.IDPrestataire = IDPrestataire;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Prestataire() {
        super();
    }


}
