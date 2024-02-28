package org.api.miprimeraapirest.repository;


import org.api.miprimeraapirest.model.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DriverRepositoryTest  {

    @Autowired DriverRepository driverRepository;

    Driver driver;

    @BeforeEach
    void setup(){
        driver = Driver.builder().code("AAA").forename("Men").surname("Man").build();
    }

    @Test
    void shouldReturnsaveDriverWhenSave(){
        Driver driverSaved = driverRepository.save(driver);

        assertThat(driverSaved).isNotNull();
        assertThat(driverSaved.getDriverId()).isGreaterThan(0);
    }

    @Test
    void shouldReturnMoreThanOneDriverWhenSaveTwoDrivers(){
        Driver driverSaved = driverRepository.save(driver);
        Driver driverSaved2 = driverRepository.save(driver);

        assertThat(driverSaved).isNotNull();
        assertThat(driverSaved2).isNotNull();
        assertThat(driverSaved.getDriverId()).isGreaterThan(0);
        assertThat(driverSaved2.getDriverId()).isGreaterThan(0);
    }

    @Test
    void shouldReturnDriverNotNullWhenUpdateDriver(){
        Driver driverSaved = driverRepository.save(driver);
        driverSaved.setForename("Women");
        Driver driverUpdated = driverRepository.save(driverSaved);

        assertThat(driverUpdated).isNotNull();
        assertThat(driverUpdated.getDriverId()).isGreaterThan(0);
        assertThat(driverUpdated.getForename()).isEqualTo("Women");
    }

    @Test
    void shouldReturnNullDriverWhenDelete(){
        Driver driverSaved = driverRepository.save(driver);
        driverRepository.delete(driverSaved);
        Driver driverDeleted = driverRepository.findById(driverSaved.getDriverId()).orElse(null);

        assertThat(driverDeleted).isNull();
    }

}