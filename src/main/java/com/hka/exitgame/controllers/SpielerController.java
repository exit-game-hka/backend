package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.SpielerDto;
import com.hka.exitgame.dto.SpielerListPageableResponse;
import com.hka.exitgame.entities.Spieler;
import com.hka.exitgame.services.SpielerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.SPIELER_ROUTE)
@Slf4j
@Tag(name = "Spieler", description = "APIs zur Verwaltung von Spielern")
public class SpielerController {

    private final SpielerService spielerService;

    @GetMapping
    @Operation(summary = "Spieler mit Suchkriterien auslesen", description = "Gibt die Spieler mit den angegebenen Suchkriterien zurück.")
    public Spieler find(@RequestParam(name = "spieler_id", required = false) final String avatarName) {
        return spielerService.findBySpielerId(avatarName);
    }

    @GetMapping("{id}")
    @Operation(summary = "Spieler mit ID auslesen", description = "Spieler mit ID auslesen")
    public Spieler findById(@PathVariable("id") final UUID id) {
        return spielerService.findById(id);
    }

    @GetMapping("/alle")
    @Operation(summary = "Alle Spieler auslesen. Ein Pageable Response wird zurückgegeben.", description = "Alle Spieler auslesen. Ein Pageable Response wird zurückgegeben.")
    public SpielerListPageableResponse findAll(
            @RequestParam(name = "semester_id", required = false) final UUID semesterId,
            @RequestParam(name = "page_number", defaultValue = "0", required = false) final Integer pageNumber,
            @RequestParam(name = "page_size", defaultValue = "5", required = false) final Integer pageSize
    ) {
        if (semesterId != null) {
            return spielerService.findBySemesterId(semesterId, pageNumber, pageSize);
        }
        return spielerService.findAll(pageNumber, pageSize);
    }

    @PostMapping
    @Operation(summary = "Spieler erstellen", description = "Spieler erstellen")
    public void create(@RequestBody final SpielerDto spielerDto) {
        spielerService.create(spielerDto);
    }

    @PutMapping
    @Operation(summary = "Spieler aktualisieren", description = "Spieler aktualisieren")
    public void update(@RequestBody final Spieler spieler) {
        spielerService.update(spieler);
    }
}
