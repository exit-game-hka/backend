package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Interaktion;

import java.util.UUID;

public record InteraktionDto(
        UUID spielerId,

        UUID aufgabeId,

        UUID gegenstandId,

        String action
) {

    public Interaktion toInteraktion() {
        return Interaktion.builder()
                .id(null)
                .spielerId(spielerId)
                .aufgabeId(aufgabeId)
                .gegenstandId(gegenstandId)
                .action(action)
                .build();
    }
}
