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

    public Ergebnis find(final UUID aufgabeId, final UUID spielerId) {
        log.info("AugabeId = {}, SpielerId = {}", aufgabeId, spielerId);
        var ergebnis = ergebnisRepository.findByAufgabeIdAndSpielerId(aufgabeId, spielerId);
        return ergebnis.orElse(null);
    }

    public List<Ergebnis> findBySemesterId(final UUID semesterId) {
        return ergebnisRepository.findBySemesterId(semesterId);
    }

    public void create(final ErgebnisDto ergebnisDto) {
        var ergebnis = ergebnisDto.toErgebnis();
        var ergebnisFromDb = ergebnisRepository.findByAufgabeIdAndSpielerId(ergebnis.getAufgabeId(), ergebnis.getSpielerId());
        if (ergebnisFromDb.isEmpty()) {
            ergebnisRepository.save(ergebnis);
            return;
        }
        var istAufgabeGeloest = ergebnisFromDb.get().getGeloestIn();
        if (istAufgabeGeloest != null) return;
        ergebnisRepository.save(ergebnis);
    }

    public List<Ergebnis> findAll() {
        return ergebnisRepository.findAll();
    }
}
