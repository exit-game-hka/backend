package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Gegenstand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GegenstandRepository extends JpaRepository<Gegenstand, UUID> {}
