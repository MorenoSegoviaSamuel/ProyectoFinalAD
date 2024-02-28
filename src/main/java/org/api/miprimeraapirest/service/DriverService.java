package org.api.miprimeraapirest.service;

import org.api.miprimeraapirest.model.Driver;
import org.api.miprimeraapirest.model.DriverDTO;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    List<DriverDTO> getAllDrivers();

    Optional<Driver> getDriverByCode(String code);

    void saveDriver(Driver driver);
    void deleteDriverByCode(String code);
}
