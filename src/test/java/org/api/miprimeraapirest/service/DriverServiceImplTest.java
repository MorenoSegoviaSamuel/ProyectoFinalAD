package org.api.miprimeraapirest.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.api.miprimeraapirest.mapper.DriverDTOMapper;
import org.api.miprimeraapirest.model.Driver;
import org.api.miprimeraapirest.model.DriverDTO;
import org.api.miprimeraapirest.repository.DriverRepository;
import org.api.miprimeraapirest.service.DriverService;
import org.api.miprimeraapirest.service.DriverServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverServiceImplTest {

    @Mock
    private DriverRepository repository;
    private DriverDTOMapper mapper;
    private DriverService service;

    @BeforeEach
    void setUp() {
        repository = mock(DriverRepository.class);
        service = new DriverServiceImpl(repository,mapper);
    }

    @Test
    void getAllDrivers() {
        // Given
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver(1L, "AAA", "John", "Doe", LocalDate.now(), "American", null, "URL AAA", null));
        drivers.add(new Driver(2L, "BBB", "Jane", "Doe", LocalDate.now(), "British", null, "URL BBB", null));
        when(repository.findAll()).thenReturn(drivers);

        // When
        List<DriverDTO> result = service.getAllDrivers();

        // Then
        assertEquals(2, result.size());
        assertEquals("AAA", result.get(0).code());
        assertEquals("BBB", result.get(1).code());
    }

    @Test
    void getDriverByCode() {
        // Given
        Driver driver = new Driver(1L, "AAA", "John", "Doe", LocalDate.now(), "American", null, "URL AAA", null);
        when(repository.findByCodeIgnoreCase("AAA")).thenReturn(Optional.of(driver));

        // When
        Optional<Driver> result = service.getDriverByCode("AAA");

        // Then
        assertTrue(result.isPresent());
        assertEquals("AAA", result.get().getCode());
    }

    @Test
    void saveDriver() {
        // Given
        Driver driverToSave = new Driver(null, "CCC", "John", "Doe", LocalDate.now(), "American", null, "URL CCC", null);
        Driver savedDriver = new Driver(1L, "CCC", "John", "Doe", LocalDate.now(), "American", null, "URL CCC", null);
        when(repository.save(driverToSave)).thenReturn(savedDriver);

        // When
        service.saveDriver(driverToSave);

        // Then
        verify(repository, times(1)).save(driverToSave);
    }

    @Test
    void deleteDriverByCode() {
        // Given
        String codeToDelete = "AAA";

        // When
        service.deleteDriverByCode(codeToDelete);

        // Then
        verify(repository, times(1)).deleteByCode(codeToDelete);
    }
}
