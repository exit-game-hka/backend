package com.hka.exitgame.repositories;

import com.hka.exitgame.entities.Spieler;
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
public class SpielerRepositoryTest {

    @Autowired
    private SpielerRepository spielerRepository;

    @Test
    public void SpielerRepository_FindAll_ShouldReturnAllSpieler() {
        // Given
        Spieler spieler1 = Spieler.builder()
                .spielerId("Spieler 1")
                .build();

        Spieler spieler2 = Spieler.builder()
                .spielerId("Spieler 2")
                .build();

        // When
        spielerRepository.save(spieler1);
        spielerRepository.save(spieler2);

        List<Spieler> spielerList = spielerRepository.findAll();

        // Then
        Assertions.assertThat(spielerList).isNotNull();
        Assertions.assertThat(spielerList.size()).isEqualTo(2);
    }

    @Test
    public void SpielerRepository_FindById_ShouldReturnASingleSpieler() {
        // Given
        Spieler spieler1 = Spieler.builder()
                .avatarName("Spieler 1")
                .build();

        // When
        spielerRepository.save(spieler1);

        List<Spieler> spielerList = spielerRepository.findAll();

        Optional<Spieler> spielerFromList = spielerList.stream().findFirst();

        Optional<Spieler> spielerFromDatabase = spielerRepository.findById(spielerFromList.get().getId());

        // Then
        Assertions.assertThat(spielerFromDatabase).isNotNull();
        Assertions.assertThat(spielerFromDatabase.get().getSpielerId()).isEqualTo("Spieler 1");
    }
}
