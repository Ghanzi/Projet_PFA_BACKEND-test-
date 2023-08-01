package com.gestion.stage1.controllers;

import com.gestion.stage1.entities.Consultant;
import com.gestion.stage1.services.implementation.ConsultantServiceImpl;
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
public class ConsultantController {

    private final ConsultantServiceImpl consultantService;

    public ConsultantController(ConsultantServiceImpl consultantService) {
        this.consultantService = consultantService;
    }


    @GetMapping("/consultants")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Consultant>> getAllConsultants() {
        List<Consultant> consultants = consultantService.getAllConsultants();
        return ResponseEntity.ok(consultants);
    }
}
