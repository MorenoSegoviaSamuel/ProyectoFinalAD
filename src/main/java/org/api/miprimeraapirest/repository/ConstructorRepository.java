package org.api.miprimeraapirest.repository;

import org.api.miprimeraapirest.model.Constructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConstructorRepository extends JpaRepository<Constructor, Long> {
    Optional<Constructor> findByConstructorRefIgnoreCase(String constructorRef);

    void deleteByConstructorRef(String constructorRef);
    Page<Constructor> findAllProjectedBy(Pageable pageable);
}
