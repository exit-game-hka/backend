package com.hka.exitgame.services;

import com.hka.exitgame.entities.Spieler;
import com.hka.exitgame.repositories.SpielerRepository;
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
public class SpielerServiceTest {

    @Mock
    private SpielerRepository spielerRepository;

    @InjectMocks
    private SpielerService spielerService;

    @Test
    public void SpielerService_FindById_ShouldReturnASingleSpieler() {
        // Given
        Spieler spieler1 = Spieler.builder()
                .avatarName("Spieler 1")
                .build();

        // When
        when(spielerRepository.findById(spieler1.getId())).thenReturn(Optional.of(spieler1));

        Spieler spielerReturn = spielerService.findById(spieler1.getId());

        // Then
        Assertions.assertThat(spielerReturn).isNotNull();
        Assertions.assertThat(spielerReturn.getAvatarName()).isEqualTo("Spieler 1");
    }

    @Test
    public void SpielerService_FindAll_ShouldReturnAllSpieler() {
        // Given
        List<Spieler> spielerList = List.of(
                Spieler.builder()
                        .avatarName("Spieler 1")
                        .build(),
                Spieler.builder()
                        .avatarName("Spieler 2")
                        .build()
        );

        // When
        when(spielerRepository.findAll()).thenReturn(spielerList);

        List<Spieler> savedSpieler = spielerService.findAll();

        // Then
        Assertions.assertThat(savedSpieler).isNotNull();
        Assertions.assertThat(savedSpieler.size()).isEqualTo(2);
    }
}
