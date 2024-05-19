package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.VeranstaltungDto;
import com.hka.exitgame.entities.Veranstaltung;
import com.hka.exitgame.services.VeranstaltungService;
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
public class VeranstaltungController {

    private final VeranstaltungService veranstaltungService;

    @GetMapping("/{id}")
    public Veranstaltung findById(@PathVariable(name = "id") final UUID id) {
        return veranstaltungService.findById(id);
    }

    @GetMapping("/alle")
    public List<Veranstaltung> findAll() {
        return veranstaltungService.findAll();
    }

    @PostMapping()
    public void create(@RequestBody final VeranstaltungDto veranstaltungDto) {
        veranstaltungService.create(veranstaltungDto);
    }

    @PutMapping
    public void update(@RequestBody final Veranstaltung veranstaltung) {
        veranstaltungService.update(veranstaltung);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") final UUID id) {
        veranstaltungService.delete(id);
    }
}
