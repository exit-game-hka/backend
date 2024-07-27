package com.hka.exitgame.services;

import com.hka.exitgame.entities.Raum;
import com.hka.exitgame.repositories.RaumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class RaumService {

    private final RaumRepository raumRepository;

    public Raum findById(UUID id) {
        var raum = raumRepository.findById(id);
        return raum.orElse(null);
    }

    public List<Raum> findAll() {
        return raumRepository.findAll();
    }

    public void update(final Raum raum) {
        raumRepository.save(raum);
    }
}
