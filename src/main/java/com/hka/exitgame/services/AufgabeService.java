package com.hka.exitgame.services;

import com.hka.exitgame.entities.Aufgabe;
import com.hka.exitgame.repositories.AufgabeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class AufgabeService {

    private final AufgabeRepository aufgabeRepository;

    public Aufgabe findById(UUID id) {
        var aufgabe = aufgabeRepository.findById(id);
        log.info("Aufgabe Id: {}", id);
        return aufgabe.orElse(null);
    }

    public List<Aufgabe> findAll() {
        return aufgabeRepository.findAll();
    }

    public void update(Aufgabe aufgabe) {
        aufgabeRepository.save(aufgabe);
    }
}
