package com.gestion.stage1.controllers;

import com.gestion.stage1.entities.Admin_Validators;
import com.gestion.stage1.entities.Consultant;
import com.gestion.stage1.services.implementation.Admin_ValidatorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class Admin_ValidatorsControllers{

    private final Admin_ValidatorServiceImpl admin_validatorService;

    public Admin_ValidatorsControllers(Admin_ValidatorServiceImpl admin_validatorService) {
        this.admin_validatorService = admin_validatorService;
    }


    @GetMapping("/validateurs")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Admin_Validators>> getAllValidators() {
        List<Admin_Validators> validateurs = admin_validatorService.getAllConsultants();
        return ResponseEntity.ok(validateurs);
    }
}
