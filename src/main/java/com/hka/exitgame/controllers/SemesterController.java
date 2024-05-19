package com.hka.exitgame.controllers;

import com.hka.exitgame.dto.SemesterDto;
import com.hka.exitgame.entities.Semester;
import com.hka.exitgame.services.SemesterService;
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
public class SemesterController {

    private final SemesterService semesterService;

    @GetMapping("/{id}")
    public Semester findById(@PathVariable("id") final UUID id) {
        return semesterService.findById(id);
    }

    @GetMapping("/alle")
    public List<Semester> findAll() {
        return semesterService.findAll();
    }

    @PostMapping
    public void create(@RequestBody final SemesterDto semesterDto) {
        semesterService.create(semesterDto);
    }

    @PutMapping
    public void update(@RequestBody final Semester semester) {
        semesterService.update(semester);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") final UUID id) {
        semesterService.delete(id);
    }
}
