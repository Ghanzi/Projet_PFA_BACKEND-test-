package com.gestion.stage1.services.implementation;

import com.gestion.stage1.entities.Admin_Validators;
import com.gestion.stage1.repositories.Admin_ValidatorsRepository;
import com.gestion.stage1.services.Admin_ValidatorService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
