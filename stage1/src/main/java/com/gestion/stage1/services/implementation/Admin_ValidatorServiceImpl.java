package com.gestion.stage1.services.implementation;

import com.gestion.stage1.entities.Admin_Validators;
import com.gestion.stage1.repositories.Admin_ValidatorsRepository;
import com.gestion.stage1.services.Admin_ValidatorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Admin_ValidatorServiceImpl implements Admin_ValidatorService {
    private final Admin_ValidatorsRepository admin_Validators_repo;

    public Admin_ValidatorServiceImpl(Admin_ValidatorsRepository admin_validators_repo) {
        admin_Validators_repo = admin_validators_repo;
    }


    @Override
    public List<Admin_Validators> getAllConsultants() {
        return admin_Validators_repo.findAll();
    }
    @Override
    public Admin_Validators saveAdmin_Validators(Admin_Validators admin_validators) {
        return admin_Validators_repo.save(admin_validators);
    }
    @Override
    public void deleteValidator(UUID id) {
        admin_Validators_repo.deleteById(id);
    }
    @Override
    public Admin_Validators updateValidator(UUID id, Admin_Validators updatedValidator) {
        Admin_Validators existingValidator = admin_Validators_repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Validator with ID " + id + " not found"));
        existingValidator.setFirst_name(updatedValidator.getFirst_name());
        existingValidator.setLast_name(updatedValidator.getLastName());
        existingValidator.setEmail(updatedValidator.getEmail());
        existingValidator.setPhone_number(updatedValidator.getPhoneNumber());
        existingValidator.setActivation(updatedValidator.getActivation());

        // Save and return the updated entity
        return admin_Validators_repo.save(existingValidator);
    }
}
