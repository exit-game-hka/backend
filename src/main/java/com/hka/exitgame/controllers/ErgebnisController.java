package com.hka.exitgame.controllers;

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
    public Ergebnis find(@RequestParam Map<String, String> params) {
        return ergebniService.find(
                UUID.fromString(params.get("aufgabeId")),
                UUID.fromString(params.get("spielerId"))
        );
    }

    @GetMapping("/alle")
    public List<Ergebnis> findAll() {
        return ergebniService.findAll();
    }
}
