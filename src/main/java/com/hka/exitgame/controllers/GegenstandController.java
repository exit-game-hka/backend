package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Gegenstand;
import com.hka.exitgame.services.GegenstandService;
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
@RequestMapping(ApiRoute.GEGENSTAND_ROUTE)
@Slf4j
@Tag(name = "Gegenstand", description = "APIs zur Verwaltung von Gegenständen")
public class GegenstandController {

    private final GegenstandService gegenstandService;

    @GetMapping("/{id}")
    @Operation(summary = "Gegenstand mit ID auslesen", description = "Gegenstand mit ID auslesen")
    public Gegenstand findById(@PathVariable("id") final UUID id) {
        return gegenstandService.findById(id);
    }

    @GetMapping("/alle")
    @Operation(summary = "Alle Gegenstände auslesen", description = "Alle Gegenstände auslesen")
    public List<Gegenstand> findAll() {
        return gegenstandService.findAll();
    }

    @PutMapping()
    @Operation(summary = "Gegenstand aktualisieren", description = "Gegenstand aktualisieren")
    public void update(@RequestBody final Gegenstand gegenstand) {
        gegenstandService.update(gegenstand);
    }
}
