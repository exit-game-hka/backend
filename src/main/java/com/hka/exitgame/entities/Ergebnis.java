package com.hka.exitgame.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ergebnis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "spieler_fk", nullable = false)
    private UUID spielerId;

    @Column(nullable = false)
    private UUID semesterId;

    @ManyToOne
    @JoinColumn(name = "spieler_fk", insertable = false, updatable = false)
    //@JsonIgnore
    @ToString.Exclude
    private Spieler spieler;

    @Column(name = "aufgabe_fk", nullable = false)
    private UUID aufgabeId;

    @ManyToOne
    @JoinColumn(name = "aufgabe_fk", insertable = false, updatable = false)
    //@JsonIgnore
    @ToString.Exclude
    private Aufgabe aufgabe;

    // TODO: Remove, not required...
    // private Integer versuch;

    // Zeiteinheit in Minuten
    private Double geloestIn;
}
