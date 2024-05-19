package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Status;

import java.util.UUID;

public record StatusDto(
        UUID spielerId,

        UUID semesterId,

        UUID veranstaltungId,

        String spielStart,

        String spielEnde,

        Boolean istSpielBeendet,

        Boolean istSpielAbgebrochen
) {

    public Status toStatus() {
        return Status.builder()
                .id(null)
                .spielerId(spielerId)
                .semesterId(semesterId)
                .veranstaltungId(veranstaltungId)
                .spielStart(spielStart)
                .spielEnde(spielEnde)
                .istSpielBeendet(istSpielBeendet)
                .istSpielAbgebrochen(istSpielAbgebrochen)
                .build();
    }
}
