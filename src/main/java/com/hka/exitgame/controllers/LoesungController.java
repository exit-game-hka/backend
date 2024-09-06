package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Loesung;
import com.hka.exitgame.services.LoesungService;
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
@RequestMapping(ApiRoute.LOESUNG_ROUTE)
@Tag(name = "Lösung", description = "APIs zur Verwaltung von Lösungen")
public class LoesungController {

    private final LoesungService loesungService;

    @GetMapping
    @Operation(summary = "Lösung mit AufgabeID auslesen", description = "Lösung mit AufgabeID auslesen")
    public Loesung findByAufgabeId(@RequestParam final Map<String, String> params) {
        return loesungService.findByAufgabeId(UUID.fromString(params.get("aufgabeId")));
    }

    @GetMapping("/alle")
    @Operation(summary = "Alle Lösungen auslesen", description = "Alle Lösungen auslesen")
    public List<Loesung> findAll() {
        return loesungService.findAll();
    }

    @PutMapping
    @Operation(summary = "Lösung aktualisieren", description = "Lösung aktualisieren")
    public void update(@RequestBody final Loesung loesung) {
        loesungService.update(loesung);
    }
}
