package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.KommentarDto;
import com.hka.exitgame.entities.Kommentar;
import com.hka.exitgame.services.KommentarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.KOMMENTAR_ROUTE)
@Slf4j
@Tag(name = "Kommentar", description = "APIs zur Verwaltung von Kommentaren")
public class KommentarController {

    private final KommentarService kommentarService;

    @GetMapping("/{id}")
    @Operation(summary = "Kommentar mit ID auslesen", description = "Kommentar mit ID auslesen")
    public Kommentar findById(@PathVariable("id") final UUID id) {
        return kommentarService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Kommentar mit Suchkriterien auslesen", description = "Gibt die Kommentare mit den angegebenen Suchkriterien zurück.")
    public List<Kommentar> find(@RequestParam final Map<String, String> params) {
        var queryParamSpierlerId = params.get("spieler_id");
        var queryParamSemesterId = params.get("semester_id");

        if (queryParamSpierlerId != null && queryParamSemesterId != null) {
            var spielerId = UUID.fromString(queryParamSpierlerId);
            var semesterId = UUID.fromString(queryParamSemesterId);
            return kommentarService.findBySpielerIdAndSemesterId(spielerId, semesterId);
        }

        if (params.size() == 1 && queryParamSpierlerId != null) {
            var spielerId = UUID.fromString(queryParamSpierlerId);
            return kommentarService.findBySpielerId(spielerId);
        }

        if (params.size() == 1 && queryParamSemesterId != null) {
            var semesterId = UUID.fromString(queryParamSemesterId);
            return kommentarService.findBySemesterId(semesterId);
        }
        return List.of();
    }

    @PostMapping
    @Operation(summary = "Kommentar erstellen", description = "Kommentar erstellen")
    public void create(@RequestBody final KommentarDto kommentarDto) {
        kommentarService.create(kommentarDto);
    }
}
