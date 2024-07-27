package com.hka.exitgame.dto;

import com.hka.exitgame.entities.SpielerFortschritt;

public record SpielerFortschrittDto(
        String spielerId,
        String prozentFortschritt,
        String updatedAt,
        String createdAt
) {
    public SpielerFortschritt toSpielerFortschritt() {
        return SpielerFortschritt.builder()
                .id(null)
                .spielerId(spielerId)
                .prozentFortschritt(prozentFortschritt)
                .updatedAt(updatedAt)
                .createdAt(createdAt)
                .build();
    }
}
