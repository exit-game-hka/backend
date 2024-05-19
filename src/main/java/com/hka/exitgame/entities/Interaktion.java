package com.hka.exitgame.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Interaktion {

    @Id
    private UUID id;

    @Column(name = "spieler_fk")
    private UUID spielerId;

    @Column(name = "aufgabe_fk")
    private UUID aufgabeId;

    @Column(name = "gegenstand_fk")
    private UUID gegenstandId;

    private String action;
}
