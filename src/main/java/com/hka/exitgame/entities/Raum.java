package com.hka.exitgame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Raum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    private String name;

    private String beschreibung;

    @OneToMany(mappedBy = "raum", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Aufgabe> aufgaben;
}
