package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Aufgabe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AufgabeRepositoryTest {

    @Autowired
    private AufgabeRepository aufgabeRepository;

    @Test
    public void AufgabeRepository_FindAll_ShouldReturnAllAufgaben() {
        // Given
        Aufgabe aufgabe1 = Aufgabe.builder()
                .wert("Frage 1")
                .zeitZuLoesen(240)
                .beschreibung("Beschreibung Augabe 1")
                .build();

        Aufgabe aufgabe2 = Aufgabe.builder()
                .wert("Frage 2")
                .zeitZuLoesen(240)
                .beschreibung("Beschreibung Augabe 2")
                .build();

        // When
        aufgabeRepository.save(aufgabe1);
        aufgabeRepository.save(aufgabe2);

        List<Aufgabe> aufgaben = aufgabeRepository.findAll();

        // Then
        Assertions.assertThat(aufgaben).isNotNull();
        Assertions.assertThat(aufgaben.size()).isEqualTo(2);

    }

    @Test
    public void AufgabeRepository_FindById_ShouldReturnASingleAufgabe() {
        // Given
        Aufgabe aufgabeTest1 = Aufgabe.builder()
                .wert("Frage 1")
                .zeitZuLoesen(240)
                .beschreibung("Beschreibung Augabe 1")
                .build();

        // When
        aufgabeRepository.save(aufgabeTest1);

        List<Aufgabe> aufgabeList = aufgabeRepository.findAll();

        Optional<Aufgabe> aufgabeFromList = aufgabeList.stream().findFirst();

        Optional<Aufgabe> aufgabeFromDatabase = aufgabeRepository.findById(aufgabeFromList.get().getId());

        // Then
        Assertions.assertThat(aufgabeFromDatabase).isNotNull();
        Assertions.assertThat(aufgabeFromDatabase.get().getZeitZuLoesen()).isEqualTo(240);
        Assertions.assertThat(aufgabeFromDatabase.get().getBeschreibung()).isEqualTo("Beschreibung Augabe 1");

    }
}
