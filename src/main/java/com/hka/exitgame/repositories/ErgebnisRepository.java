package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Ergebnis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ErgebnisRepository extends JpaRepository<Ergebnis, UUID> {

    List<Ergebnis> findByAufgabeIdAndSpielerId(UUID aufgabeFk, UUID spielerFk);

    List<Ergebnis> findBySemesterId(final UUID semesterId);
}
