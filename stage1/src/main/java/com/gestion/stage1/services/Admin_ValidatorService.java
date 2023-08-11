package com.gestion.stage1.services;

import com.gestion.stage1.entities.Admin_Validators;

import java.util.List;
import java.util.UUID;

public interface Admin_ValidatorService {
    List<Admin_Validators> getAllConsultants();

    Admin_Validators saveAdmin_Validators(Admin_Validators admin_validators);

    void deleteValidator(UUID id);

    Admin_Validators updateValidator(UUID id, Admin_Validators updatedValidator);
}
