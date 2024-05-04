package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Ergebnis;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ErgebnisRepositoryTest {

    @Autowired
    private ErgebnisRepository ergebnisRepository;

    @Test
    public void ErgebnisRepository_FindAll_ShouldReturnAllErgebnisse() {
        // Given
        Ergebnis ergebnis1 = Ergebnis.builder()
                .versuch(2)
                .geloestIn(200)
                .build();

        Ergebnis ergebnis2 = Ergebnis.builder()
                .versuch(2)
                .geloestIn(60)
                .build();

        // When
        ergebnisRepository.save(ergebnis1);
        ergebnisRepository.save(ergebnis2);

        List<Ergebnis> ergebnisList = ergebnisRepository.findAll();

        // Then
        Assertions.assertThat(ergebnisList).isNotNull();
        Assertions.assertThat(ergebnisList.size()).isEqualTo(2);
    }

    @Test
    public void ErgebnisRepository_FindById_ShouldReturnASingleErgebnis() {
        // Given
        Ergebnis ergebnis1 = Ergebnis.builder()
                .versuch(2)
                .geloestIn(200)
                .build();

        // When
        ergebnisRepository.save(ergebnis1);

        List<Ergebnis> ergebnisList = ergebnisRepository.findAll();

        Optional<Ergebnis> ergebnisFromList = ergebnisList.stream().findFirst();

        Optional<Ergebnis> ergebnisFromDatabase = ergebnisRepository.findById(ergebnisFromList.get().getId());

        // Then
        Assertions.assertThat(ergebnisFromDatabase).isNotNull();
        Assertions.assertThat(ergebnisFromDatabase.get().getVersuch()).isEqualTo(2);
        Assertions.assertThat(ergebnisFromDatabase.get().getGeloestIn()).isEqualTo(200);
    }
}
