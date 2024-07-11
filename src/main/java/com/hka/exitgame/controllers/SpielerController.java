package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.SpielerDto;
import com.hka.exitgame.dto.SpielerListPageableResponse;
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

    @GetMapping
    public Spieler find(@RequestParam(name = "spieler_id", required = false) final String avatarName) {
        return spielerService.findBySpielerId(avatarName);
    }

    @GetMapping("{id}")
    public Spieler findById(@PathVariable("id") final UUID id) {
        return spielerService.findById(id);
    }

    @GetMapping("/alle")
    public SpielerListPageableResponse findAll(
            @RequestParam(name = "semester_id", required = false) final UUID semesterId,
            @RequestParam(name = "page_number", defaultValue = "0", required = false) final Integer pageNumber,
            @RequestParam(name = "page_size", defaultValue = "5", required = false) final Integer pageSize
    ) {
        if (semesterId != null) {
            return spielerService.findBySemesterId(semesterId, pageNumber, pageSize);
        }
        return spielerService.findAll(pageNumber, pageSize);
    }

    @PostMapping
    public void create(@RequestBody final SpielerDto spielerDto) {
        spielerService.create(spielerDto);
    }

    @PutMapping
    public void update(@RequestBody final Spieler spieler) {
        spielerService.update(spieler);
    }
}
