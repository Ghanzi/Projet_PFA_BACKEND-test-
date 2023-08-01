package com.gestion.stage1.repositories;

import com.gestion.stage1.entities.Admin_Validators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Admin_ValidatorsRepository extends JpaRepository<Admin_Validators, UUID> {
}
