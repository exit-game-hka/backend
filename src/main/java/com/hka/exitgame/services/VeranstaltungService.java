package com.hka.exitgame.services;

import com.hka.exitgame.dto.VeranstaltungDto;
import com.hka.exitgame.entities.Veranstaltung;
import com.hka.exitgame.repositories.VeranstaltungRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VeranstaltungService {

    private final VeranstaltungRepository veranstaltungRepository;

    public Veranstaltung findById(final UUID id) {
        return veranstaltungRepository.findById(id).orElse(null);
    }

    public List<Veranstaltung> findAll() {
        return veranstaltungRepository.findAll();
    }

    public void create(final VeranstaltungDto veranstaltungDto) {
        var veranstaltung = veranstaltungDto.toVeranstaltung();
        veranstaltungRepository.save(veranstaltung);
    }

    public void update(final Veranstaltung veranstaltung) {
        veranstaltungRepository.save(veranstaltung);
    }

    public void delete(final UUID id) {
        veranstaltungRepository.deleteById(id);
    }
}
