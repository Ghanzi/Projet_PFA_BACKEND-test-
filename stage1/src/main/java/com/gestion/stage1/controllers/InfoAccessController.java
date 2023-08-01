package com.gestion.stage1.controllers;

import com.gestion.stage1.entities.InfoAccess;
import com.gestion.stage1.services.implementation.AccessInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/accessInfo")
@CrossOrigin("*")
public class InfoAccessController {
    @Autowired
    private AccessInfoServiceImpl accessInfoService; //we are bringing in Employee Service instance


    @PostMapping
    public InfoAccess saveAccessInfo(@RequestBody InfoAccess accessInfo){
        return accessInfoService.saveAccessInfo(accessInfo);
    }

    @GetMapping
    public List<InfoAccess> getAllAccessInfo(){
        return accessInfoService.getAllAccessInfo();
    }
    @GetMapping("/{id}")
    public Optional<InfoAccess> getAccessInfoById(@PathVariable UUID id){
        return accessInfoService.getAccessInfoById(id);
    }

    @PutMapping("/{id}")
    public InfoAccess updateAccessInfo(@PathVariable UUID id, @RequestBody InfoAccess accessInfo){
        return accessInfoService.updateAccessInfo(id,accessInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteAccessInfo(@PathVariable UUID id){
        accessInfoService.deleteAccessInfo(id);
    }

}
