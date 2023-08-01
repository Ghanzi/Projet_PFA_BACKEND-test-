package com.gestion.stage1.services.implementation;

import com.gestion.stage1.entities.InfoAccess;
import com.gestion.stage1.repositories.InfoAccessRepository;
import com.gestion.stage1.services.AccessInfoService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccessInfoServiceImpl implements AccessInfoService {

    private final InfoAccessRepository accessInfoRepository;

    public AccessInfoServiceImpl(InfoAccessRepository accessInfoRepository) {
        this.accessInfoRepository = accessInfoRepository;
    }

   @Override
    public Optional<InfoAccess> getAccessInfoById(UUID id) {
        return accessInfoRepository.findById(id);
    }

    @Override
    public List<InfoAccess> getAllAccessInfo() {
        return accessInfoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
    @Override
    public InfoAccess saveAccessInfo(InfoAccess accessInfo) {
        return accessInfoRepository.save(accessInfo);
    }


    @Override
    public InfoAccess updateAccessInfo(UUID id, InfoAccess accessInfo) {
        InfoAccess accessInfoToUpdate = accessInfoRepository.findById(id).orElseThrow();
        accessInfoToUpdate.setDate(accessInfo.getDate());
        accessInfoToUpdate.setTime(accessInfo.getTime());
        accessInfoToUpdate.setIDInfoAccess(accessInfo.getIDInfoAccess());
        return accessInfoRepository.save(accessInfoToUpdate);
    }

    @Override
    public void deleteAccessInfo(UUID id) {
        accessInfoRepository.deleteById(id);
    }
}
