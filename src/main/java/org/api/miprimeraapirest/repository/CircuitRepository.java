package org.api.miprimeraapirest.repository;

import org.api.miprimeraapirest.model.Circuit;
import org.api.miprimeraapirest.model.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CircuitRepository extends JpaRepository<Circuit, Long> {

    Optional<Circuit> findByCircuitRefIgnoreCase(String circuitRef);
    void deleteByCircuitRef(String circuitRef);
}
