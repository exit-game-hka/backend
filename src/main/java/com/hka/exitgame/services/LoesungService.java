package com.hka.exitgame.services;

import com.hka.exitgame.entities.Loesung;
import com.hka.exitgame.repositories.LoesungRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class LoesungService {

    private final LoesungRepository loesungRepository;

    public Loesung findByAufgabeId(UUID aufgabeId) {
        var loesung = loesungRepository.findByAufgabeId(aufgabeId);
        return loesung.orElse(null);
    }

    public List<Loesung> findAll() {
        return loesungRepository.findAll();
    }
}
