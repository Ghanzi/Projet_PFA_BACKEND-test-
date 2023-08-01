package com.gestion.stage1.controllers;

import com.gestion.stage1.entities.Timesheet;
import com.gestion.stage1.repositories.TimesheetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/Timesheets")
public class TimesheetController {
    private final TimesheetRepository timesheetRepository;

    public TimesheetController(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    @GetMapping
    public List<Timesheet> getAllTimesheets() {
        return timesheetRepository.findAll();
    }

    @GetMapping("/{id}")
    public Timesheet getTimesheetById(@PathVariable UUID id) {
        return timesheetRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Timesheet not found with id: " + id));
    }
}
