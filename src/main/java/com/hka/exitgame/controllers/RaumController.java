package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Raum;
import com.hka.exitgame.services.RaumService;
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
@RequestMapping(ApiRoute.RAUM_ROUTE)
@Slf4j
@Tag(name = "Raum", description = "APIs zur Verwaltung von Räumen")
public class RaumController {

    private final RaumService raumService;

    @GetMapping("/{id}")
    @Operation(summary = "Raum mit ID auslesen", description = "Raum mit ID auslesen")
    public Raum findById(@PathVariable("id") final UUID id) {
        return raumService.findById(id);
    }

    @GetMapping("/alle")
    @Operation(summary = "Alle Räume auslesen", description = "Alle Räume auslesen")
    public List<Raum> findAll() {
        return raumService.findAll();
    }

    @PutMapping
    @Operation(summary = "Raum aktualisieren", description = "Raum aktualisieren")
    public void update(@RequestBody final Raum raum) {
        raumService.update(raum);
    }
}
