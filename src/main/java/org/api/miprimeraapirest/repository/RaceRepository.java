package org.api.miprimeraapirest.repository;

import org.api.miprimeraapirest.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Optional<Race> findByRound(int round);

    void deleteByRound(int round);
}