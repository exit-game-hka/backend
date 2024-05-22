package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Interaktion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InteraktionRepository extends JpaRepository<Interaktion, UUID> {

    List<Interaktion> findBySpielerIdAndAufgabeId(UUID spielerId, UUID aufgabeId);
}
