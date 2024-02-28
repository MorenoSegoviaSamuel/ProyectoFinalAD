package org.api.miprimeraapirest.repository;

import org.api.miprimeraapirest.model.Constructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@DataJpaTest
public class ConstructorRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15.5");

    @Autowired
    ConstructorRepository constructorRepository;

    Constructor constructor;

    @BeforeEach
    void setup(){
        constructor = Constructor.builder().constructorId(1L).constructorRef("AAA").name("Pepe").nationality("Si").build();
    }

    @Test
    void shouldReturnConstructorNotNullWhenFindConstructorByRef(){
        Constructor constructor = new Constructor();
        constructor.setConstructorRef("AAA");

        Constructor constructorSaved = constructorRepository.save(constructor);
        Constructor constructorFound = constructorRepository.findByConstructorRefIgnoreCase("AAA").orElse(null);


        assertThat(constructorFound).isNotNull();
        assertThat(constructorFound.getConstructorId()).isEqualTo(constructorSaved.getConstructorId());
    }

    @Test
    void shouldReturnConstructorNotNullWhenDeleteConstructorByRef(){
        Constructor constructorSaved = constructorRepository.save(constructor);
        constructorRepository.delete(constructorSaved);
        Constructor constructorDeleted = constructorRepository.findByConstructorRefIgnoreCase("AAA").orElse(null);

        assertThat(constructorDeleted).isNull();
    }


}