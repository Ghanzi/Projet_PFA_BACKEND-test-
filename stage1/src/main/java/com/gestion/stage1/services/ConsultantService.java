package com.gestion.stage1.services;

import com.gestion.stage1.entities.Consultant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConsultantService {
    List<Consultant> getAllConsultants();
    Optional<Consultant> getConsultantById(UUID id);

    Consultant saveConsultant(Consultant consultant);

    Consultant updateConsultant(UUID id, Consultant consultant);

    void deleteConsultant(UUID id);
}
