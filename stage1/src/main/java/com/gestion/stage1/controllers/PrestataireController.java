package com.gestion.stage1.controllers;

import com.gestion.stage1.entities.Consultant;
import com.gestion.stage1.entities.Prestataire;
import com.gestion.stage1.services.PrestataireService;
import com.gestion.stage1.services.implementation.PrestataireServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/Prestataire")
public class PrestataireController {

    private final PrestataireServiceImpl prestataireService;

    public PrestataireController(PrestataireServiceImpl prestataireService) {
        this.prestataireService = prestataireService;
    }

    @GetMapping("/prestataires")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_VALIDATEUR')")
    public ResponseEntity<List<Prestataire>> getAllPrestataires() {
        List<Prestataire> prestataires = prestataireService.getAllPrestataires();
        return ResponseEntity.ok(prestataires);
    }

    @GetMapping("/prestataires/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_VALIDATEUR')")
    public ResponseEntity<Prestataire> getPrestataireById(@PathVariable UUID id) {
        Prestataire prestataire = prestataireService.getPrestataireById(id);
        if (prestataire != null) {
            return ResponseEntity.ok(prestataire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("api/v1/Prestataire")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Prestataire> addPrestataire(@RequestBody Prestataire prestataire) {
        Prestataire savedPrestataire = prestataireService.savePrestataire(prestataire);
        return ResponseEntity.ok(savedPrestataire);
    }

    @PutMapping("/updateprestatire/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Prestataire> updatePrestataire(@PathVariable UUID id, @RequestBody Prestataire prestataire) {
        Prestataire updatedPrestataire = prestataireService.updatePrestataire(id, prestataire);
        if (updatedPrestataire != null) {
            return ResponseEntity.ok(updatedPrestataire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteprestaire/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deletePrestataire(@PathVariable UUID id) {
        prestataireService.deletePrestataire(id);
        return ResponseEntity.ok().build();
    }
}
