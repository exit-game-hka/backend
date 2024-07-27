package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.SpielerFortschritt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpielerFortschrittRepository extends JpaRepository<SpielerFortschritt, UUID> {

    Optional<SpielerFortschritt> findBySpielerId(final String spielerId);
}
