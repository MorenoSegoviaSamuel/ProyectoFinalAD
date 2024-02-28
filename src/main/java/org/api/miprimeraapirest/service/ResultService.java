package org.api.miprimeraapirest.service;

import org.api.miprimeraapirest.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ResultService {
    List<Result> getAllResults();

    Optional<Result> findByRaceId(Long raceId);
}