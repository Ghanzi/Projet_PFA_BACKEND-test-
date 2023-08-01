package com.gestion.stage1.services.implementation;

import com.gestion.stage1.entities.Consultant;
import com.gestion.stage1.entities.InfoAccess;
import com.gestion.stage1.repositories.ConsultantRepository;
import com.gestion.stage1.services.ConsultantService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultantServiceImpl implements ConsultantService {

    private final ConsultantRepository consultant_repo;

    public ConsultantServiceImpl(ConsultantRepository consultant_repo) {
        this.consultant_repo = consultant_repo;
    }

    @Override
    public List<Consultant> getAllConsultants() {
        return consultant_repo.findAll();
    }

    @Override
    public Optional<Consultant> getConsultantById(UUID id) {
        return consultant_repo.findById(id);
    }


    @Override
    public Consultant saveConsultant(Consultant consultant) {
        return consultant_repo.save(consultant);
    }


    @Override
    public Consultant updateConsultant(UUID id, Consultant consultant) {
        Consultant c = consultant_repo.findById(id).orElseThrow();
        c.setFirst_name(consultant.getFirst_name());
        c.setLast_name(consultant.getLast_name());
        c.setEmail(consultant.getEmail());
        c.setPhone_number(consultant.getPhone_number());
        c.setService_name(consultant.getService_name());
        c.setMission_description(consultant.getMission_description());
        c.setPrestataire(consultant.getPrestataire());
        return consultant_repo.save(c);
    }

    @Override
    public void deleteConsultant(UUID id) {
        consultant_repo.deleteById(id);
    }
}
