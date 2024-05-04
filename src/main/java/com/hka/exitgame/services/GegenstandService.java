package com.hka.exitgame.services;

import com.hka.exitgame.entities.Gegenstand;
import com.hka.exitgame.repositories.GegenstandRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class GegenstandService {

    private final GegenstandRepository gegenstandRepository;

    public Gegenstand findById(UUID id) {
        var gegenstand = gegenstandRepository.findById(id);
        return gegenstand.orElse(null);
    }

    public List<Gegenstand> findAll() {
        return gegenstandRepository.findAll();
    }

    public void update(Gegenstand gegenstand) {
        gegenstandRepository.save(gegenstand);
    }
}
