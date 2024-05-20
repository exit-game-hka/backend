package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Spieler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpielerRepository extends JpaRepository<Spieler, UUID> {

    Optional<Spieler> findBySpielerId(final String spielerId);
}
