package com.gestion.stage1.services.implementation;

import com.gestion.stage1.entities.Timesheet;
import com.gestion.stage1.repositories.TimesheetRepository;
import com.gestion.stage1.services.TimesheetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class TimesheetImpl implements TimesheetService {
    private final TimesheetRepository timesheetRepository;

    public TimesheetImpl(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    @Override
    public List<Timesheet> getAllTimesheets() {
        return timesheetRepository.findAll();
    }
    @Override
    public Timesheet getTimesheetById(UUID id) {
        return timesheetRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Timesheet not found with id: " + id));
    }

    @Override
    public Timesheet createTimesheet(Timesheet timesheet) {

        return timesheetRepository.save(timesheet);
    }

    @Override
    public Timesheet updateTimesheet(UUID id, Timesheet updatedTimesheet) {
        return null;
    }

    /*@Override
    public Timesheet updateTimesheet(UUID id, Timesheet updatedTimesheet) {
        Timesheet existingTimesheet = timesheetRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Timesheet not found with id: " + id));

        // Mettez à jour les propriétés pertinentes de la feuille de temps existante avec les nouvelles valeurs
        existingTimesheet.setEmployeeName(updatedTimesheet.getEmployeeName());
        existingTimesheet.setDate(updatedTimesheet.getDate());
        existingTimesheet.setHoursWorked(updatedTimesheet.getHoursWorked());

        return timesheetRepository.save(existingTimesheet);
    }*/
    @Override
    public void deleteTimesheet(UUID id) {
        Timesheet existingTimesheet = timesheetRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Timesheet not found with id: " + id));

        timesheetRepository.delete(existingTimesheet);
    }
}
