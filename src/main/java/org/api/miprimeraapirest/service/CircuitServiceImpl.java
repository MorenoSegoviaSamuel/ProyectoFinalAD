package org.api.miprimeraapirest.service;

import org.api.miprimeraapirest.model.Circuit;
import org.api.miprimeraapirest.repository.CircuitRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitServiceImpl implements CircuitService{

    private final CircuitRepository repository;

    public CircuitServiceImpl(CircuitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Circuit> getAllCircuits() {
        return repository.findAll();
    }

    @Override
    public Optional<Circuit> getCircuitByCircuitRef(String circuitRef) {
        return repository.findByCircuitRefIgnoreCase(circuitRef);
    }

    @Override
    public void saveCircuit(Circuit circuit) {
        repository.save(circuit);
    }

    @Override
    public void deleteCircuitByCircuitRef(String circuitRef) {
        repository.deleteByCircuitRef(circuitRef);
    }
}
