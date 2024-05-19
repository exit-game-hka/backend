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
        var spieler = spielerRepository.findById(id);
        log.info("Spieler Id: {}", id);
        return spieler.orElse(null);
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
