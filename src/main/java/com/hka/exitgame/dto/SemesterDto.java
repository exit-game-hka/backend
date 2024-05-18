package com.hka.exitgame.dto;

import com.hka.exitgame.entities.Semester;

public record SemesterDto(
        String start,
        String ende,
        String bezeichnung
) {

    public Semester toSemester() {
        return Semester.builder()
                .id(null)
                .start(start)
                .ende(ende)
                .bezeichnung(bezeichnung)
                .build();
    }
}
