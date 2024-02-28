package org.api.miprimeraapirest.service;

import org.api.miprimeraapirest.model.Result;
import org.api.miprimeraapirest.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService{
    private final ResultRepository repository;

    public ResultServiceImpl(ResultRepository repository) {
        this.repository = repository;
    }

    public List<Result> getAllResults() {
        return repository.findAll();
    }

    public Optional<Result> findByRaceId(Long raceId) {
        return repository.findById(raceId);
    }
}