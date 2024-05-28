package com.hka.exitgame.services;

import com.hka.exitgame.dto.KommentarDto;
import com.hka.exitgame.entities.Kommentar;
import com.hka.exitgame.repositories.KommentarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class KommentarService {

    private final KommentarRepository kommentarRepository;

    public List<Kommentar> findBySpielerIdAndSemesterId(final UUID spierlerId, final UUID semesterId) {
        return kommentarRepository.findBySpielerIdAndSemesterId(spierlerId, semesterId);
    }

    public List<Kommentar> findBySpielerId(final UUID spierlerId) {
        return kommentarRepository.findBySpielerId(spierlerId);
    }

    public List<Kommentar> findBySemesterId(final UUID semesterId) {
        return kommentarRepository.findBySemesterId(semesterId);
    }

    public Kommentar findById(final UUID id) {
        return kommentarRepository.findById(id).orElse(null);
    }

    public void create(final KommentarDto kommentarDto) {
        var kommentar = kommentarDto.toKommentar();
        kommentarRepository.save(kommentar);
    }
}
