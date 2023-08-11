package com.gestion.stage1.controllers;

import com.gestion.stage1.entities.Admin_Validators;
import com.gestion.stage1.entities.Consultant;
import com.gestion.stage1.services.implementation.Admin_ValidatorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/Admin_Validators")
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
    @PostMapping("/validateurs")
    public Admin_Validators saveAdmin_Validators(@RequestBody Admin_Validators admin_validators){
        return admin_validatorService.saveAdmin_Validators(admin_validators);
    }
    @DeleteMapping("/validateurs/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteValidator(@PathVariable UUID id) {
        admin_validatorService.deleteValidator(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/validateurs/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Admin_Validators> updateValidator(
            @PathVariable UUID id, @RequestBody Admin_Validators updatedValidator) {
        Admin_Validators result = admin_validatorService.updateValidator(id, updatedValidator);
        return ResponseEntity.ok(result);
    }
}
