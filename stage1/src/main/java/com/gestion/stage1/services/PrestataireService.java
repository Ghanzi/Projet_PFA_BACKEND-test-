package com.gestion.stage1.services;

import com.gestion.stage1.entities.Prestataire;

import java.util.List;
import java.util.UUID;

public interface PrestataireService {
    List<Prestataire> getAllPrestataires();

    Prestataire getPrestataireById(UUID id);

    Prestataire savePrestataire(Prestataire prestataire);

    Prestataire updatePrestataire(UUID id, Prestataire prestataire);

    void deletePrestataire(UUID id);
}