package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.VeranstaltungDto;
import com.hka.exitgame.entities.Veranstaltung;
import com.hka.exitgame.services.VeranstaltungService;
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
@RequestMapping(ApiRoute.VERANSTALTUNG_ROUTE)
@Slf4j
@Tag(name = "Veranstaltung", description = "APIs zur Verwaltung von Veranstaltungen")
public class VeranstaltungController {

    private final VeranstaltungService veranstaltungService;

    @GetMapping("/{id}")
    @Operation(summary = "Veranstaltung mit ID auslesen", description = "Veranstaltung mit ID auslesen")
    public Veranstaltung findById(@PathVariable(name = "id") final UUID id) {
        return veranstaltungService.findById(id);
    }

    @GetMapping("/alle")
    @Operation(summary = "Alle Veranstaltungen auslesen", description = "Alle Veranstaltungen auslesen.")
    public List<Veranstaltung> findAll() {
        return veranstaltungService.findAll();
    }

    @PostMapping()
    @Operation(summary = "Veranstaltung erstellen", description = "Veranstaltung erstellen")
    public void create(@RequestBody final VeranstaltungDto veranstaltungDto) {
        veranstaltungService.create(veranstaltungDto);
    }

    @PutMapping
    @Operation(summary = "Veranstaltung aktualisieren", description = "Veranstaltung aktualisieren")
    public void update(@RequestBody final Veranstaltung veranstaltung) {
        veranstaltungService.update(veranstaltung);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Veranstaltung löschen", description = "Veranstaltung löschen")
    public void delete(@PathVariable(name = "id") final UUID id) {
        veranstaltungService.delete(id);
    }
}
