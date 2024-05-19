package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatusRepository extends JpaRepository<Status, UUID> {

    Optional<Status> findBySpielerId(final UUID id);

    List<Status> findBySemesterId(final UUID id);
}
