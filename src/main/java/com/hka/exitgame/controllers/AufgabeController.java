package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Aufgabe;
import com.hka.exitgame.services.AufgabeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.AUFGABE_ROUTE)
@Slf4j
@Tag(name = "Aufgabe", description = "APIs zur Verwaltung von Aufgaben")
public class AufgabeController {

    private final AufgabeService aufgabeService;

    @GetMapping("/{id}")
    @Operation(summary = "Aufgabe mit ID auslesen", description = "Gibt die Aufgabe mit der angegebenen ID zurück.")
    public Aufgabe findById(@PathVariable("id") final UUID id) {
        return aufgabeService.findById(id);
    }

    @GetMapping("/alle")
    @Operation(summary = "Alle Aufgaben auslesen", description = "Gibt alle Aufgabe zurück.")
    public List<Aufgabe> findAll() {
        return aufgabeService.findAll();
    }

    @PutMapping()
    @Operation(summary = "Aufgabe aktualisieren", description = "Aktualisiert die angegebene Aufgabe.")
    public void update(@RequestBody Aufgabe aufgabe) {
        aufgabeService.update(aufgabe);
    }
}
