package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Gegenstand;
import com.hka.exitgame.services.GegenstandService;
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
public class GegenstandController {

    private final GegenstandService gegenstandService;

    @GetMapping("/{id}")
    public Gegenstand findById(@PathVariable("id") final UUID id) {
        return gegenstandService.findById(id);
    }

    @GetMapping("/alle")
    public List<Gegenstand> findAll() {
        return gegenstandService.findAll();
    }

    @PutMapping()
    public void update(@RequestBody final Gegenstand gegenstand) {
        gegenstandService.update(gegenstand);
    }
}
