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
public class Interaktion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "spieler_fk")
    private UUID spielerId;

    @Column(name = "aufgabe_fk")
    private UUID aufgabeId;

    // TODO: Remove !!!. Not used anymore since game objects are managed on client side.
    @Column(name = "gegenstand_fk")
    private UUID gegenstandId;

    private String action;
}
