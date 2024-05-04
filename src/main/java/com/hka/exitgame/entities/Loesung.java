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
public class Loesung {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    private String wert;

    @Column(name = "aufgabe_fk")
    private UUID aufgabeId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "aufgabe_fk", insertable = false, updatable = false)
    @JsonIgnore
    private Aufgabe aufgabe;
}
