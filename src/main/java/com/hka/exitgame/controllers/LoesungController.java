package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Loesung;
import com.hka.exitgame.services.LoesungService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.LOESUNG_ROUTE)
public class LoesungController {

    private final LoesungService loesungService;

    @GetMapping
    public Loesung findByAufgabeId(@RequestParam final Map<String, String> params) {
        return loesungService.findByAufgabeId(UUID.fromString(params.get("aufgabeId")));
    }

    @GetMapping("/alle")
    public List<Loesung> findAll() {
        return loesungService.findAll();
    }

    @PutMapping
    public void update(@RequestBody final Loesung loesung) {
        loesungService.update(loesung);
    }
}
