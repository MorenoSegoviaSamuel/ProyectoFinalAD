package org.api.miprimeraapirest.service;


import org.api.miprimeraapirest.mapper.DriverDTOMapper;
import org.api.miprimeraapirest.model.Driver;
import org.api.miprimeraapirest.model.DriverDTO;
import org.api.miprimeraapirest.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    private final DriverDTOMapper mapper;

    @Autowired
    public DriverServiceImpl(DriverRepository driverService, DriverDTOMapper mapper){
        this.mapper = mapper;
        this.repository = driverService;
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<DriverDTO> response = new ArrayList<>();

        repository.findAll().forEach(driver -> response.add(mapper.toDriverDTO(driver)));

        return response;
    }

    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return repository.findByCodeIgnoreCase(code);
    }

    @Override
    public void saveDriver(Driver driver) {
        repository.save(driver);
    }



    @Override
    public void deleteDriverByCode(String code) {
        repository.deleteByCode(code);
    }
}