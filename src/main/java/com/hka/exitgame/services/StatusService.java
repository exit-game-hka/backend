package com.hka.exitgame.services;

import com.hka.exitgame.dto.StatusDto;
import com.hka.exitgame.entities.Status;
import com.hka.exitgame.repositories.StatusRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class StatusService {

    private final StatusRepository statusRepository;

    public Status findBySpielerId(final UUID id) {
        return statusRepository.findBySpielerId(id).orElse(null);
    }

    public List<Status> findBySemesterId(final UUID id) {
        return statusRepository.findBySemesterId(id);
    }

    public void create(final StatusDto statusDto) {
        var status = statusDto.toStatus();
        var statusDb = statusRepository.findBySpielerId(status.getSpielerId());

        if (statusDb.isPresent()) {
            log.info("Status of student: {} already exists", status.getSpielerId());
            return;
        }
        statusRepository.save(status);
    }

    public void update(final Status status) {
        statusRepository.save(status);
    }
}
