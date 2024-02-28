package org.api.miprimeraapirest.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.api.miprimeraapirest.model.Constructor;
import org.api.miprimeraapirest.repository.ConstructorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConstructorServiceImplTest {

    @Mock
    private ConstructorRepository repository;

    private ConstructorService service;

    @BeforeEach
    void setUp() {
        repository = mock(ConstructorRepository.class);
        service = new ConstructorServiceImpl(repository);
    }

    @Test
    void getAllConstructors() {
        // Given
        List<Constructor> constructors = new ArrayList<>();
        constructors.add(new Constructor(1L, "AAA", "Constructor AAA", "Nationality AAA", "URL AAA"));
        constructors.add(new Constructor(2L, "BBB", "Constructor BBB", "Nationality BBB", "URL BBB"));
        when(repository.findAll()).thenReturn(constructors);

        // When
        List<Constructor> result = service.getAllConstructors();

        // Then
        assertEquals(2, result.size());
        assertEquals("AAA", result.get(0).getConstructorRef());
        assertEquals("BBB", result.get(1).getConstructorRef());
    }

    @Test
    void getConstructorByConstructorRef() {
        // Given
        Constructor constructor = new Constructor(1L, "AAA", "Constructor AAA", "Nationality AAA", "URL AAA");
        when(repository.findByConstructorRefIgnoreCase("AAA")).thenReturn(Optional.of(constructor));

        // When
        Optional<Constructor> result = service.getConstructorByConstructorRef("AAA");

        // Then
        assertTrue(result.isPresent());
        assertEquals("AAA", result.get().getConstructorRef());
    }

    @Test
    void saveConstructor() {
        // Given
        Constructor constructorToSave = new Constructor(null, "CCC", "Constructor CCC", "Nationality CCC", "URL CCC");
        Constructor savedConstructor = new Constructor(1L, "CCC", "Constructor CCC", "Nationality CCC", "URL CCC");
        when(repository.save(constructorToSave)).thenReturn(savedConstructor);

        // When
        service.saveConstructor(constructorToSave);

        // Then
        verify(repository, times(1)).save(constructorToSave);
    }
}
