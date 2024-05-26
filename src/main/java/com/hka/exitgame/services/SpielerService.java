package com.hka.exitgame.services;

import com.hka.exitgame.dto.SpielerDto;
import com.hka.exitgame.entities.Spieler;
import com.hka.exitgame.repositories.SpielerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class SpielerService {

    private final SpielerRepository spielerRepository;

    public Spieler findById(UUID id) {
        return spielerRepository.findById(id).orElse(null);
    }

    public Spieler findBySpielerId(final String id) {
        return spielerRepository.findBySpielerId(id).orElse(null);
    }

    public List<Spieler> findBySemesterId(final UUID semesterId) {
        return spielerRepository.findBySemesterId(semesterId);
    }

    public List<Spieler> findAll() {
        return spielerRepository.findAll();
    }

    public void create(final SpielerDto spielerDto) {
        var spieler = spielerDto.toSpieler();
        spielerRepository.save(spieler);
    }

    public void update(Spieler spieler) {
        spielerRepository.save(spieler);
    }
}
