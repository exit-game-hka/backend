package com.hka.exitgame.services;

import com.hka.exitgame.dto.SpielerDto;
import com.hka.exitgame.dto.SpielerListPageableResponse;
import com.hka.exitgame.entities.Spieler;
import com.hka.exitgame.entities.SpielerFortschritt;
import com.hka.exitgame.repositories.SpielerFortschrittRepository;
import com.hka.exitgame.repositories.SpielerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class SpielerService {

    private final SpielerRepository spielerRepository;
    private final SpielerFortschrittRepository spielerFortschrittRepository;

    public Spieler findById(UUID id) {
        return spielerRepository.findById(id).orElse(null);
    }

    public Spieler findBySpielerId(final String id) {
        return spielerRepository.findBySpielerId(id).orElse(null);
    }

    public SpielerListPageableResponse findBySemesterId(final UUID semesterId, final Integer pageNumber, final Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Spieler> spielerListPage = spielerRepository.findBySemesterId(semesterId, pageable);

        return buildSpielerListPage(spielerListPage);
    }

    public SpielerListPageableResponse findAll(final Integer pageNumber, final Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Spieler> spielerListPage = spielerRepository.findAll(pageable);

        return buildSpielerListPage(spielerListPage);
    }

    private SpielerListPageableResponse buildSpielerListPage(Page<Spieler> spielerListPage) {
        return SpielerListPageableResponse.builder()
                .pageContent(spielerListPage.getContent())
                .pageNumber(spielerListPage.getNumber())
                .pageSize(spielerListPage.getSize())
                .totalElements(spielerListPage.getTotalElements())
                .totalPages(spielerListPage.getTotalPages())
                .isFirst(spielerListPage.isFirst())
                .isLast(spielerListPage.isLast())
                .build();
    }

    public void create(final SpielerDto spielerDto) {
        var spieler = spielerDto.toSpieler();
        var savedEntity = spielerRepository.save(spieler);

        var spielerFortschritt = SpielerFortschritt.builder()
                .id(null)
                .spielerId(savedEntity.getSpielerId())
                .prozentFortschritt("0%")
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();

        spielerFortschrittRepository.save(spielerFortschritt);
    }

    public void update(Spieler spieler) {
        spielerRepository.save(spieler);
    }
}
