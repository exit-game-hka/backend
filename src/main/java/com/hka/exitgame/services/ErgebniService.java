package com.hka.exitgame.services;

import com.hka.exitgame.dto.ErgebnisDto;
import com.hka.exitgame.entities.Ergebnis;
import com.hka.exitgame.repositories.ErgebnisRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ErgebniService {

    private final ErgebnisRepository ergebnisRepository;

    public List<Ergebnis> findByAufgabeIdAndSpielerId(final UUID aufgabeId, final UUID spielerId) {
        log.info("AugabeId = {}, SpielerId = {}", aufgabeId, spielerId);
        return ergebnisRepository.findByAufgabeIdAndSpielerId(aufgabeId, spielerId);
    }

    public List<Ergebnis> findBySemesterId(final UUID semesterId) {
        return ergebnisRepository.findBySemesterId(semesterId);
    }

    public List<Ergebnis> findBySpielerId(final UUID id) {
        return ergebnisRepository.findBySpielerId(id);
    }

    public void create(final ErgebnisDto ergebnisDto) {
        var ergebnis = ergebnisDto.toErgebnis();
        var ergebnisListFromDb = ergebnisRepository.findByAufgabeIdAndSpielerId(ergebnis.getAufgabeId(), ergebnis.getSpielerId());

        ergebnisListFromDb.forEach(e -> {
            log.info("ergebnisLitFromDb: {}", e);
        });

        if (ergebnisListFromDb.isEmpty()) {
            ergebnisRepository.save(ergebnis);
            return;
        }
        var istAufgabeGeloest = ergebnisListFromDb
                .stream()
                .filter(e -> e.getGeloestIn() != null)
                .toList();
        if (!istAufgabeGeloest.isEmpty()) return;
        ergebnisRepository.save(ergebnis);
    }

    public List<Ergebnis> findAll() {
        return ergebnisRepository.findAll();
    }
}
