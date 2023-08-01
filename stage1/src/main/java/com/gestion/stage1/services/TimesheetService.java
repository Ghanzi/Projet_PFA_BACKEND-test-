package com.gestion.stage1.services;

import com.gestion.stage1.entities.Timesheet;

import java.util.List;
import java.util.UUID;

public interface TimesheetService {
    List<Timesheet> getAllTimesheets();

    Timesheet getTimesheetById(UUID id);

    Timesheet createTimesheet(Timesheet timesheet);

    Timesheet updateTimesheet(UUID id, Timesheet updatedTimesheet);

    void deleteTimesheet(UUID id);
}