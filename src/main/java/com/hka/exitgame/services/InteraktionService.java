package com.hka.exitgame.services;

import com.hka.exitgame.entities.Interaktion;
import com.hka.exitgame.repositories.InteraktionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class InteraktionService {

    private final InteraktionRepository interaktionRepository;

    public Interaktion find(UUID spielerId, UUID gegenstandId) {
        var interaktion = interaktionRepository.findByGegenstandIdAndSpielerId(gegenstandId, spielerId);
        return interaktion.orElse(null);
    }

    public List<Interaktion> findAll() {
        return interaktionRepository.findAll();
    }
}
