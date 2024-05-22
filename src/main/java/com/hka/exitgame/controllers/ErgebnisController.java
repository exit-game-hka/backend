package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.ErgebnisDto;
import com.hka.exitgame.entities.Ergebnis;
import com.hka.exitgame.services.ErgebniService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.ERGEBNIS_ROUTE)
@Slf4j
public class ErgebnisController {

    private final ErgebniService ergebniService;

    @GetMapping
    public List<Ergebnis> find(@RequestParam Map<String, String> params) {
        return ergebniService.find(
                UUID.fromString(params.get("aufgabe_id")),
                UUID.fromString(params.get("spieler_id"))
        );
    }

    @PostMapping
    public void create(@RequestBody final ErgebnisDto ergebnisDto) {
        ergebniService.create(ergebnisDto);
    }

//    @GetMapping("/alle")
//    public List<Ergebnis> findAll() {
//        return ergebniService.findAll();
//    }

    @GetMapping("/semester/{id}")
    public List<Ergebnis> findBySemesterId(@PathVariable("id") final UUID id) {
        return ergebniService.findBySemesterId(id);
    }
}
