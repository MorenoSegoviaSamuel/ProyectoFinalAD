package org.api.miprimeraapirest.service;

import org.api.miprimeraapirest.model.Race;

import java.util.List;
import java.util.Optional;

public interface RaceService {

    Optional<Race> findByRound(int round);
    List<Race> getAllRaces();
    void saveRace(Race race);

    void deleteRaceByRound(int round);

}
