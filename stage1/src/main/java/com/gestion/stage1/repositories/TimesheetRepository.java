package com.gestion.stage1.repositories;

import com.gestion.stage1.entities.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, UUID> {
}