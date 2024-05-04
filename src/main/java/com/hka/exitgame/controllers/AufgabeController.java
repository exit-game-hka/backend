package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Aufgabe;
import com.hka.exitgame.services.AufgabeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.AUFGABE_ROUTE)
@Slf4j
public class AufgabeController {

    private final AufgabeService aufgabeService;

    @GetMapping("/{id}")
    public Aufgabe findById(@PathVariable("id") final UUID id) {
        return aufgabeService.findById(id);
    }

    @GetMapping("/alle")
    public List<Aufgabe> findAll() {
        return aufgabeService.findAll();
    }

    @PutMapping()
    public void update(@RequestBody Aufgabe aufgabe) {
        aufgabeService.update(aufgabe);
    }
}
