package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Loesung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoesungRepository extends JpaRepository<Loesung, UUID> {

    Optional<Loesung> findByAufgabeId(final UUID aufgabeId);
}
