package com.example.shop.service;


import com.example.shop.dto.OsDto;
import com.example.shop.entity.Os;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.OsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OsService {
    @Autowired
    private OsRepository osRepository;

    public OsDto get(Integer id) {
        Os os = getEntity(id);
        OsDto osDto = new OsDto();
        osDto.setName(os.getName());
        osDto.setId(os.getId());
        osRepository.save(os);
        return osDto;
    }

    public OsDto create(OsDto osDto) {
        Os os = new Os();
        os.setName(osDto.getName());
        os.setCreatedAt(LocalDateTime.now());
        osRepository.save(os);
        osDto.setId(os.getId());
        return osDto;
    }

    public boolean update(Integer id, OsDto osDto) {
        Os update = getEntity(id);
        update.setName(osDto.getName());
        update.setUpdatedAt(LocalDateTime.now());
        osRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Os delete = getEntity(id);
        delete.setDeletedAt(LocalDateTime.now());
        osRepository.save(delete);
        return true;
    }
    public Os getEntity(Integer id) {
        Optional<Os> optional = osRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("OS not found");
        }
        return optional.get();
    }
}
