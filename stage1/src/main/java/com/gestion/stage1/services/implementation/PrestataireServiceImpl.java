package com.gestion.stage1.services.implementation;

import com.gestion.stage1.entities.Prestataire;
import com.gestion.stage1.repositories.PrestataireRepository;
import com.gestion.stage1.services.PrestataireService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class PrestataireServiceImpl implements PrestataireService {

    private final PrestataireRepository prestataireRepository;

    public PrestataireServiceImpl(PrestataireRepository prestataireRepository) {
        this.prestataireRepository = prestataireRepository;
    }

    @Override
    public List<Prestataire> getAllPrestataires() {
        return prestataireRepository.findAll();
    }

    @Override
    public Prestataire getPrestataireById(UUID id) {
        return prestataireRepository.findById(id).orElse(null);
    }

    @Override
    public Prestataire savePrestataire(Prestataire prestataire) {
        return prestataireRepository.save(prestataire);
    }

    @Override
    public Prestataire updatePrestataire(UUID id, Prestataire prestataire) {
        Prestataire p = prestataireRepository.findById(id).orElse(null);
        if (p != null) {
            p.setName(prestataire.getName());
            p.setEmail(prestataire.getEmail());
            p.setContract(prestataire.getContract());
            return prestataireRepository.save(p);
        }
        return null;
    }



    @Override
    public void deletePrestataire(UUID id) {
        prestataireRepository.deleteById(id);
    }
}