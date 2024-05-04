package com.hka.exitgame.services;

import com.hka.exitgame.entities.Aufgabe;
import com.hka.exitgame.repositories.AufgabeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AufgabeServiceTest {

    @Mock
    private AufgabeRepository aufgabeRepository;

    @InjectMocks
    private AufgabeService aufgabeService;

    @Test
    public void AufgabeService_FindById_ShouldReturnASingleAufgabe() {
        // Given
        Aufgabe aufgabe1 = Aufgabe.builder()
                .wert("Frage 1")
                .zeitZuLoesen(240)
                .beschreibung("Beschreibung Augabe 1")
                .build();

        // When
        when(aufgabeRepository.findById(aufgabe1.getId())).thenReturn(Optional.of(aufgabe1));

        Aufgabe aufgabeReturn = aufgabeService.findById(aufgabe1.getId());

        // Then
        Assertions.assertThat(aufgabeReturn).isNotNull();
        Assertions.assertThat(aufgabeReturn.getWert()).isEqualTo("Frage 1");
        Assertions.assertThat(aufgabeReturn.getZeitZuLoesen()).isEqualTo(240);
        Assertions.assertThat(aufgabeReturn.getBeschreibung()).isEqualTo("Beschreibung Augabe 1");
    }

    @Test
    public void AufgabeService_FindAll_ShouldReturnAllAufgaben() {
        // Given
        List<Aufgabe> aufgabeList = List.of(
                Aufgabe.builder()
                        .wert("Frage 1")
                        .zeitZuLoesen(240)
                        .beschreibung("Beschreibung Augabe 1")
                        .build(),
                Aufgabe.builder()
                        .wert("Frage 2")
                        .zeitZuLoesen(240)
                        .beschreibung("Beschreibung Augabe 2")
                        .build()
        );

        // When
        when(aufgabeRepository.findAll()).thenReturn(aufgabeList);

        List<Aufgabe> savedAufgaben = aufgabeService.findAll();

        // Then
        Assertions.assertThat(savedAufgaben).isNotNull();
        Assertions.assertThat(savedAufgaben.size()).isEqualTo(2);
    }
}
