package com.hka.exitgame.services;

import com.hka.exitgame.entities.Ergebnis;
import com.hka.exitgame.repositories.ErgebnisRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ErgbenisServiceTest {

    @Mock
    private ErgebnisRepository ergebnisRepository;

    @InjectMocks
    private ErgebniService ergebniService;

    @Test
    public void ErgebnisService_FindAll_ShouldReturnAllErgebnisse() {
        // Given
        List<Ergebnis> ergebnisList = List.of(
                Ergebnis.builder()
                        .versuch(2)
                        .geloestIn(200)
                        .build(),
                Ergebnis.builder()
                        .versuch(2)
                        .geloestIn(60)
                        .build()
        );

        // When
        when(ergebnisRepository.findAll()).thenReturn(ergebnisList);

        List<Ergebnis> ergebnisReturn = ergebniService.findAll();

        // Then
        Assertions.assertThat(ergebnisReturn).isNotNull();
        Assertions.assertThat(ergebnisReturn.size()).isEqualTo(2);
    }
}
