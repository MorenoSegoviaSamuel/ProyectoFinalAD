package org.api.miprimeraapirest.service;

import org.api.miprimeraapirest.model.Circuit;

import java.util.List;
import java.util.Optional;

public interface CircuitService {

    List<Circuit> getAllCircuits();

    Optional<Circuit> getCircuitByCircuitRef(String circuitRef);

    void saveCircuit(Circuit circuit);

    void deleteCircuitByCircuitRef(String circuitRef);
}