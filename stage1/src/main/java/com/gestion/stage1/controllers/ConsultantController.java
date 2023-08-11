package com.gestion.stage1.controllers;

import com.gestion.stage1.entities.Consultant;
import com.gestion.stage1.entities.InfoAccess;
import com.gestion.stage1.services.implementation.ConsultantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/Consultant")
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
    @PostMapping("/consultant")
    public Consultant saveConsultant(@RequestBody Consultant consultant){
        return consultantService.saveConsultant(consultant);
    }
    @DeleteMapping("/consultant/{id}")
    public ResponseEntity<String> deleteConsultant(@PathVariable UUID id) {
        try {
            consultantService.deleteConsultant(id);
            return new ResponseEntity<>("Consultant deleted successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Consultant not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the consultant", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/consultant/{id}")
    public ResponseEntity<Consultant> updateConsultant(
            @PathVariable UUID id, @RequestBody Consultant updatedConsultant) {
        try {
            Consultant result = consultantService.updateConsultant(id, updatedConsultant);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
