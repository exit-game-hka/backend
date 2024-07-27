package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.SpielerFortschrittDto;
import com.hka.exitgame.entities.SpielerFortschritt;
import com.hka.exitgame.services.SpielerFortschrittService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.SPIELER_FORTSCHRITT_ROUTE)
@Slf4j
public class SpielerFortschrittController {

    private final SpielerFortschrittService spielerFortschrittService;

    @GetMapping("/{spielerId}")
    public SpielerFortschritt findSpielerFortschrittBySpielerId(@PathVariable("spielerId") final String spielerId) {
        return spielerFortschrittService.findSpielerFortschrittBySpielerId(spielerId);
    }

    @PostMapping
    public void createSpielerFortschritt(@RequestBody final SpielerFortschrittDto spielerFortschrittDTO) {
        spielerFortschrittService.createSpielerFortschritt(spielerFortschrittDTO);
    }

    @PutMapping
    public void updateSpielerFortschritt(@RequestBody final SpielerFortschritt spielerFortschritt) {
        spielerFortschrittService.updateSpielerFortschritt(spielerFortschritt);
    }
}
