package com.hka.exitgame.services;

import com.hka.exitgame.dto.InteraktionDto;
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

    public List<Interaktion> findBySpielerIdAndAufgabeId(UUID spielerId, UUID aufgabeId) {
        return interaktionRepository.findBySpielerIdAndAufgabeId(spielerId, aufgabeId);
    }

    public void create(final InteraktionDto interaktionDto) {
        var interaktion = interaktionDto.toInteraktion();
        interaktionRepository.save(interaktion);
    }

    public List<Interaktion> findAll() {
        return interaktionRepository.findAll();
    }
}
