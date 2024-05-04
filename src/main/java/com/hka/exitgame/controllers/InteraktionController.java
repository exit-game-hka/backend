package com.hka.exitgame.controllers;

import com.hka.exitgame.entities.Interaktion;
import com.hka.exitgame.services.InteraktionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.INTERAKTION_ROUTE)
public class InteraktionController {

    private final InteraktionService interaktionService;

    @GetMapping
    public Interaktion find(@RequestParam Map<String, String> params) {
        return interaktionService.find(
                UUID.fromString(params.get("spielerId")),
                UUID.fromString(params.get("gegenstandId"))
        );
    }

    @GetMapping("/alle")
    public List<Interaktion> findAll() {
        return interaktionService.findAll();
    }
}
