package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Aufgabe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AufgabeRepository extends JpaRepository<Aufgabe, UUID> {}
