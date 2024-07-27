package com.hka.exitgame.services;

import com.hka.exitgame.dto.SpielerFortschrittDto;
import com.hka.exitgame.entities.SpielerFortschritt;
import com.hka.exitgame.repositories.SpielerFortschrittRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpielerFortschrittService {

    private final SpielerFortschrittRepository spielerFortschrittRepository;

    public SpielerFortschritt findSpielerFortschrittBySpielerId(final String spielerId) {
        return spielerFortschrittRepository.findBySpielerId(spielerId).orElse(null);
    }

    public void createSpielerFortschritt(final SpielerFortschrittDto spielerFortschrittDTO) {
        var spielerFortschritt = spielerFortschrittDTO.toSpielerFortschritt();
        spielerFortschrittRepository.save(spielerFortschritt);
    }

    public void updateSpielerFortschritt(final SpielerFortschritt spielerFortschritt) {
        var spielerFortschrittFromDb = spielerFortschrittRepository.findById(spielerFortschritt.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("SpielerFortschritt not found")
                );
        spielerFortschrittFromDb.setProzentFortschritt(spielerFortschritt.getProzentFortschritt());
        spielerFortschrittFromDb.setUpdatedAt(spielerFortschritt.getUpdatedAt());
        spielerFortschrittFromDb.setCreatedAt(spielerFortschritt.getCreatedAt());

        spielerFortschrittRepository.save(spielerFortschrittFromDb);
    }
}
