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
public class Spieler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    private String avatarName;

    @ManyToMany
    @JoinTable(
            name = "ergebnis",
            joinColumns = @JoinColumn(name = "spieler_fk"),
            inverseJoinColumns = @JoinColumn(name = "aufgabe_fk")
    )
    @JsonIgnore
    private List<Aufgabe> aufgaben;
}
