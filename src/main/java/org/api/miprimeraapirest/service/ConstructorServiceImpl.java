package org.api.miprimeraapirest.service;

import org.api.miprimeraapirest.model.Constructor;
import org.api.miprimeraapirest.repository.ConstructorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorServiceImpl implements ConstructorService{

    private final ConstructorRepository repository;

    public ConstructorServiceImpl(ConstructorRepository constructorRepository){this.repository = constructorRepository;}
    @Override
    public List<Constructor> getAllConstructors() {
        return repository.findAll();
    }

    @Override
    public Page<Constructor> getAllConstructorsPaged(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return repository.findAllProjectedBy(pageable);
    }

    @Override
    public Optional<Constructor> getConstructorByConstructorRef(String constructorRef) {
        return repository.findByConstructorRefIgnoreCase(constructorRef);
    }

    @Override
    public void saveConstructor(Constructor constructor) {
        repository.save(constructor);
    }

    @Override
    public void deleteConstructorByConstructorRef(String constructorRef) {
        repository.deleteByConstructorRef(constructorRef);
    }
}
