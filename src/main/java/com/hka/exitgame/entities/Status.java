package com.hka.exitgame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(unique = true)
    private UUID spielerId;

    private UUID semesterId;

    private UUID veranstaltungId;

    private String spielStart;

    private String spielEnde;

    @Column(nullable = false)
    private Boolean istSpielBeendet;

    @Column(nullable = false)
    private Boolean istSpielAbgebrochen;
}
