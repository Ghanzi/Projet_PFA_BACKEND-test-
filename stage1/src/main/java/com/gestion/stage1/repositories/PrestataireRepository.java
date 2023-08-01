package com.gestion.stage1.repositories;


import com.gestion.stage1.entities.Prestataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrestataireRepository extends JpaRepository<Prestataire, UUID> {
}
