package com.gestion.stage1.controllers;

import com.gestion.stage1.entities.Consultant;
import com.gestion.stage1.entities.Timesheet;
import com.gestion.stage1.repositories.TimesheetRepository;
import com.gestion.stage1.services.TimesheetService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTimesheet(@PathVariable UUID id) {
        try {
            timesheetService.deleteTimesheet(id);
            return new ResponseEntity<>("Timesheet deleted successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Timesheet not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the timesheet", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Timesheet> updateTimesheet(
            @PathVariable UUID id, @RequestBody Timesheet updatedTimesheet) {
        try {
            Timesheet result = timesheetService.updateTimesheet(id, updatedTimesheet);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
