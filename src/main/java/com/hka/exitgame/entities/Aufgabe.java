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
public class Aufgabe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @Column(name = "raum_fk")
    private UUID raumId;

    private String wert;

    private Integer zeitZuLoesen;

    private String beschreibung;

    @OneToMany(mappedBy = "aufgabe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Loesung> loesungen;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "raum_fk", insertable = false, updatable = false)
    @JsonIgnore
    private Raum raum;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "gegenstand_aufgabe",
            joinColumns = @JoinColumn(name = "aufgabe_fk"),
            inverseJoinColumns = @JoinColumn(name = "gegenstand_fk")
    )
    private List<Gegenstand> gegenstaende;

    // TODO: Change "aufgaben" to "spieler" ? Check that Dependency is been properly loaded
    @ManyToMany(mappedBy = "aufgaben")
    @JsonIgnore
    private List<Spieler> spielerList;
}
