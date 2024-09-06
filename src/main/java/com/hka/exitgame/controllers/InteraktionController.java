package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.InteraktionDto;
import com.hka.exitgame.entities.Interaktion;
import com.hka.exitgame.services.InteraktionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.INTERAKTION_ROUTE)
@Tag(name = "Interaktion", description = "APIs zur Verwaltung von Interaktionen")
public class InteraktionController {

    private final InteraktionService interaktionService;

    @GetMapping
    @Operation(summary = "Interaktion mit Suchkriterien auslesen", description = "Gibt die Interaktionen mit den angegebenen Suchkriterien zurück.")
    public List<Interaktion> find(@RequestParam Map<String, String> params) {
        var queryParamAufgabeId = params.get("aufgabe_id");
        var queryParamSpielerId = params.get("spieler_id");

        if (queryParamAufgabeId != null && queryParamSpielerId != null) {
            return interaktionService.findBySpielerIdAndAufgabeId(
                    UUID.fromString(queryParamSpielerId),
                    UUID.fromString(queryParamAufgabeId)
            );
        }

        if (params.size() == 1 && queryParamSpielerId != null) {
            return interaktionService.findBySpielerId(UUID.fromString(queryParamSpielerId));
        }

        return List.of();
    }

    @GetMapping("/alle")
    @Operation(summary = "Alle Interaktionen auslesen", description = "Alle Interaktionen auslesen")
    public List<Interaktion> findAll() {
        return interaktionService.findAll();
    }

    @PostMapping
    @Operation(summary = "Interaktion erstellen", description = "Interaktion erstellen")
    public void create(@RequestBody final InteraktionDto interaktionDto) {
        interaktionService.create(interaktionDto);
    }

}
