package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.ErgebnisDto;
import com.hka.exitgame.entities.Ergebnis;
import com.hka.exitgame.services.ErgebniService;
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
@RequestMapping(ApiRoute.ERGEBNIS_ROUTE)
@Slf4j
@Tag(name = "Ergebnis", description = "APIs zur Verwaltung von Ergebnissen")
public class ErgebnisController {

    private final ErgebniService ergebniService;

    @GetMapping
    @Operation(summary = "Ergebnis mit Suchkriterien auslesen", description = "Gibt die Ergebnisse mit den angegebenen Suchkriterien zurück.")
    public List<Ergebnis> find(@RequestParam Map<String, String> params) {
        var queryParamAufgabeId = params.get("aufgabe_id");
        var queryParamSpielerId = params.get("spieler_id");

        if (queryParamAufgabeId != null && queryParamSpielerId != null) {
            return ergebniService.findByAufgabeIdAndSpielerId(
                    UUID.fromString(queryParamAufgabeId),
                    UUID.fromString(queryParamSpielerId)
            );
        }

        if (params.size() == 1 && queryParamSpielerId != null) {
            return ergebniService.findBySpielerId(UUID.fromString(queryParamSpielerId));
        }

        return List.of();
    }

    @PostMapping
    @Operation(summary = "Ergebnis erstellen", description = "Ergebnis erstellen")
    public void create(@RequestBody final ErgebnisDto ergebnisDto) {
        ergebniService.create(ergebnisDto);
    }

//    @GetMapping("/alle")
//    public List<Ergebnis> findAll() {
//        return ergebniService.findAll();
//    }


    @GetMapping("/semester/{id}")
    @Operation(summary = "Ergebnis mit semesterID auslesen", description = "Ergebnis mit semesterID auslesen")
    public List<Ergebnis> findBySemesterId(@PathVariable("id") final UUID id) {
        return ergebniService.findBySemesterId(id);
    }
}
