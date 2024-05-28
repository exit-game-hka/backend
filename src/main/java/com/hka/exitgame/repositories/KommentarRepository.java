package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Kommentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KommentarRepository extends JpaRepository<Kommentar, UUID> {

    List<Kommentar> findBySemesterId(final UUID semesterId);

    List<Kommentar> findBySpielerId(final UUID spierlerId);

    List<Kommentar> findBySpielerIdAndSemesterId(final UUID spierlerId, final UUID semesterId);
}
