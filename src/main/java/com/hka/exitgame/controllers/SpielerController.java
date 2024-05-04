package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Spieler;
import com.hka.exitgame.services.SpielerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.SPIELER_ROUTE)
@Slf4j
public class SpielerController {

    private final SpielerService spielerService;

    @GetMapping("{id}")
    public Spieler findById(@PathVariable("id") final UUID id) {
        return spielerService.findById(id);
    }

    @GetMapping("/alle")
    public List<Spieler> findAll() {
        return spielerService.findAll();
    }

    @PutMapping
    public void update(@RequestBody final Spieler spieler) {
        spielerService.update(spieler);
    }
}
