package org.api.miprimeraapirest.service;

import org.api.miprimeraapirest.model.Constructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ConstructorService {
    List<Constructor> getAllConstructors();

    Page<Constructor> getAllConstructorsPaged(int pageNo, int pageSize, String sortBy, String sortDirection);
    Optional<Constructor> getConstructorByConstructorRef(String constructorRef);

    void saveConstructor(Constructor constructor);

    void deleteConstructorByConstructorRef(String constructorRef);
}
