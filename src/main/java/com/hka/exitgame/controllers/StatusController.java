package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.StatusDto;
import com.hka.exitgame.entities.Status;
import com.hka.exitgame.services.StatusService;
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
public class StatusController {

    private final StatusService statusService;

    @GetMapping("/spieler/{id}")
    public Status findBySpielerId(@PathVariable(name = "id") final UUID id) {
        return statusService.findBySpielerId(id);
    }

    @GetMapping("/semester/{id}")
    public List<Status> findBySemesterId(@PathVariable(name = "id") final UUID id) {
        return statusService.findBySemesterId(id);
    }

    @PostMapping
    public void create(@RequestBody final StatusDto statusDto) {
        statusService.create(statusDto);
    }

    @PutMapping
    public void update(@RequestBody final Status status) {
        statusService.update(status);
    }
}
