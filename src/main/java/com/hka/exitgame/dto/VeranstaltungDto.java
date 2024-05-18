package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Veranstaltung;

public record VeranstaltungDto(
        String name,
        String bezeichnung,
        String beschreibung
) {

    public Veranstaltung toVeranstaltung() {
        return Veranstaltung.builder()
                .id(null)
                .name(name)
                .bezeichnung(bezeichnung)
                .beschreibung(beschreibung)
                .build();
    }
}
