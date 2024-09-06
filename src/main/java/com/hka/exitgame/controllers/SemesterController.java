package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.SemesterDto;
import com.hka.exitgame.entities.Semester;
import com.hka.exitgame.services.SemesterService;
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
@RequestMapping(ApiRoute.SEMESTER_ROUTE)
@Slf4j
@Tag(name = "Semester", description = "APIs zur Verwaltung von Semestern")
public class SemesterController {

    private final SemesterService semesterService;

    @GetMapping("/{id}")
    @Operation(summary = "Semester mit ID auslesen", description = "Semester mit ID auslesen")
    public Semester findById(@PathVariable("id") final UUID id) {
        return semesterService.findById(id);
    }

    @GetMapping("/alle")
    @Operation(summary = "Alle Semester auslesen", description = "Alle Semester auslesen")
    public List<Semester> findAll() {
        return semesterService.findAll();
    }

    @PostMapping
    @Operation(summary = "Semester erstellen", description = "Semester erstellen")
    public void create(@RequestBody final SemesterDto semesterDto) {
        semesterService.create(semesterDto);
    }

    @PutMapping
    @Operation(summary = "Semester aktualisieren", description = "Semester aktualisieren")
    public void update(@RequestBody final Semester semester) {
        semesterService.update(semester);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Semester mit ID löschen", description = "Semester mit ID löschen")
    public void delete(@PathVariable(name = "id") final UUID id) {
        semesterService.delete(id);
    }
}
