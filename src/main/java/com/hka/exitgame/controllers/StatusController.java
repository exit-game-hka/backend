package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.StatusDto;
import com.hka.exitgame.entities.Status;
import com.hka.exitgame.services.StatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(ApiRoute.STATUS_ROUTE)
@Slf4j
@Tag(name = "Status", description = "APIs zur Verwaltung von Status")
public class StatusController {

    private final StatusService statusService;

    @GetMapping("/spieler/{id}")
    @Operation(summary = "Status mit SpielerID auslesen", description = "Status mit SpielerID auslesen")
    public Status findBySpielerId(@PathVariable(name = "id") final UUID id) {
        return statusService.findBySpielerId(id);
    }

    @GetMapping("/semester/{id}")
    @Operation(summary = "Status mit SemesterID auslesen", description = "Status mit SemesterID auslesen")
    public List<Status> findBySemesterId(@PathVariable(name = "id") final UUID id) {
        return statusService.findBySemesterId(id);
    }

    @PostMapping
    @Operation(summary = "Status erstellen", description = "Status erstellen")
    public void create(@RequestBody final StatusDto statusDto) {
        statusService.create(statusDto);
    }

    @PutMapping
    @Operation(summary = "Status aktualisieren", description = "Status aktualisieren")
    public void update(@RequestBody final Status status) {
        statusService.update(status);
    }
}
