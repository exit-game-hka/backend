package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Interaktion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InteraktionRepository extends JpaRepository<Interaktion, UUID> {

    List<Interaktion> findByGegenstandIdAndAufgabeId(UUID gegenstandFk, UUID aufgabeId);
}
