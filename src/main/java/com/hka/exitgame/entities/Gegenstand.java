package com.hka.exitgame.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Gegenstand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    private String name;

    private String beschreibung;

    private String hinweis;

    private Boolean greifbar;

    @ManyToMany(mappedBy = "gegenstaende")
    @JsonIgnore
    private List<Aufgabe> aufgaben;
}
