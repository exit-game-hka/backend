package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.KommentarDto;
import com.hka.exitgame.entities.Kommentar;
import com.hka.exitgame.services.KommentarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.KOMMENTAR_ROUTE)
@Slf4j
public class KommentarController {

    private final KommentarService kommentarService;

    @GetMapping("/{id}")
    public Kommentar findById(@PathVariable("id") final UUID id) {
        return kommentarService.findById(id);
    }

    @GetMapping
    public List<Kommentar> find(@RequestParam final Map<String, String> params) {
        var queryParamSpierlerId = params.get("spieler_id");
        var queryParamSemesterId = params.get("semester_id");

        if (queryParamSpierlerId != null && queryParamSemesterId != null) {
            var spielerId = UUID.fromString(queryParamSpierlerId);
            var semesterId = UUID.fromString(queryParamSemesterId);
            return kommentarService.findBySpielerIdAndSemesterId(spielerId, semesterId);
        }

        if (params.size() == 1 && queryParamSpierlerId != null) {
            var spielerId = UUID.fromString(queryParamSpierlerId);
            return kommentarService.findBySpielerId(spielerId);
        }

        if (params.size() == 1 && queryParamSemesterId != null) {
            var semesterId = UUID.fromString(queryParamSemesterId);
            return kommentarService.findBySemesterId(semesterId);
        }
        return List.of();
    }

    @PostMapping
    public void create(@RequestBody final KommentarDto kommentarDto) {
        kommentarService.create(kommentarDto);
    }
}
