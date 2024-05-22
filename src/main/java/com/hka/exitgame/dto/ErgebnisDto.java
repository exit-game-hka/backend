package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Ergebnis;

import java.util.UUID;

public record ErgebnisDto(
        UUID spielerId,
        UUID aufgabeId,
        UUID semesterId,
        Double geloestIn
) {

    public Ergebnis toErgebnis() {
        return Ergebnis.builder()
                .id(null)
                .spielerId(spielerId)
                .aufgabeId(aufgabeId)
                .geloestIn(geloestIn)
                .semesterId(semesterId)
                .build();
    }
}
