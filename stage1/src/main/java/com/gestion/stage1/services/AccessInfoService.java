package com.gestion.stage1.services;

import com.gestion.stage1.entities.InfoAccess;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccessInfoService {

    Optional<InfoAccess> getAccessInfoById(UUID id);
    List<InfoAccess> getAllAccessInfo();

    InfoAccess saveAccessInfo(InfoAccess accessInfo);

    InfoAccess updateAccessInfo(UUID id, InfoAccess accessInfo);

    void deleteAccessInfo(UUID id);
}
