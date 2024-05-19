package com.hka.exitgame.services;

import com.hka.exitgame.dto.StatusDto;
import com.hka.exitgame.entities.Status;
import com.hka.exitgame.repositories.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
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
        statusRepository.save(status);
    }

    public void update(final Status status) {
        statusRepository.save(status);
    }
}
