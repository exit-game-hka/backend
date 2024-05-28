package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.InteraktionDto;
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
    public List<Interaktion> find(@RequestParam Map<String, String> params) {
        var queryParamAufgabeId = params.get("aufgabe_id");
        var queryParamSpielerId = params.get("spieler_id");

        if (queryParamAufgabeId != null && queryParamSpielerId != null) {
            return interaktionService.findBySpielerIdAndAufgabeId(
                    UUID.fromString(queryParamSpielerId),
                    UUID.fromString(queryParamAufgabeId)
            );
        }

        if (params.size() == 1 && queryParamSpielerId != null) {
            return interaktionService.findBySpielerId(UUID.fromString(queryParamSpielerId));
        }

        return List.of();
    }

    @GetMapping("/alle")
    public List<Interaktion> findAll() {
        return interaktionService.findAll();
    }

    @PostMapping
    public void create(@RequestBody final InteraktionDto interaktionDto) {
        interaktionService.create(interaktionDto);
    }

}
