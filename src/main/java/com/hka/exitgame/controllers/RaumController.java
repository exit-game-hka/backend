package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Raum;
import com.hka.exitgame.services.RaumService;
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
public class RaumController {

    private final RaumService raumService;

    @GetMapping("/{id}")
    public Raum findById(@PathVariable("id") final UUID id) {
        return raumService.findById(id);
    }

    @GetMapping("/alle")
    public List<Raum> findAll() {
        return raumService.findAll();
    }

    @PutMapping
    public void update(@RequestBody final Raum raum) {
        raumService.update(raum);
    }
}
