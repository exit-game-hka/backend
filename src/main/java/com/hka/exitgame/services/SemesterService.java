package com.hka.exitgame.services;

import com.hka.exitgame.dto.SemesterDto;
import com.hka.exitgame.entities.Semester;
import com.hka.exitgame.repositories.SemesterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class SemesterService {

    private final SemesterRepository semesterRepository;

    public Semester findById(final UUID id) {
        return semesterRepository.findById(id).orElse(null);
    }

    public List<Semester> findAll() {
        return semesterRepository.findAll();
    }

    public void create(final SemesterDto semesterDto) {
        var semester = semesterDto.toSemester();
        semesterRepository.save(semester);
    }

    public void update(final Semester semester) {
        semesterRepository.save(semester);
    }

    public void delete(final UUID id) {
        semesterRepository.deleteById(id);
    }
}
