package com.gestion.stage1.controllers;

import com.gestion.stage1.entities.Consultant;
import com.gestion.stage1.entities.Timesheet;
import com.gestion.stage1.repositories.TimesheetRepository;
import com.gestion.stage1.services.TimesheetService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Timesheets")
@RequiredArgsConstructor
public class TimesheetController {
    private final TimesheetService timesheetService;


    @GetMapping
    public List<Timesheet> getAllTimesheets() {
        return timesheetService.getAllTimesheets();
    }

    @GetMapping("/{id}")
    public Timesheet getTimesheetById(@PathVariable UUID id) {
        return timesheetService.getTimesheetById(id);

    }
    @PostMapping("/{idUser}")
    public Timesheet saveTimesheets(@RequestBody Timesheet timesheet,@PathVariable UUID idUser){
        return timesheetService.createTimesheet(timesheet,idUser);
    }
}
