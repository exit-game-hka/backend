package com.hka.exitgame.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Ergebnis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "spieler_fk")
    private UUID spielerId;

    @ManyToOne
    @JoinColumn(name = "spieler_fk", insertable = false, updatable = false)
    @JsonIgnore
    private Spieler spieler;

    @Column(name = "aufgabe_fk")
    private UUID aufgabeId;

    @ManyToOne
    @JoinColumn(name = "aufgabe_fk", insertable = false, updatable = false)
    @JsonIgnore
    private Aufgabe aufgabe;

    private Integer versuch;

    private Integer geloestIn;
}
