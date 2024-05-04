package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Ergebnis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ErgebnisRepository extends JpaRepository<Ergebnis, UUID> {

    Optional<Ergebnis> findByAufgabeIdAndSpielerId(UUID aufgabeFk, UUID spielerFk);
}
