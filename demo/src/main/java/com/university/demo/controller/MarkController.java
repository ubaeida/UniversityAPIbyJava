package com.university.demo.controller;

import com.university.demo.models.Mark;
import com.university.demo.services.MarkService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;


interface MarkRepository extends CrudRepository<Mark, Long> {}
@RestController
@RequestMapping("/marks")
public class MarkController {
    private final MarkRepository markRepository;

    public MarkController(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @GetMapping
    Iterable<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    @PostMapping
    Mark addNewMark(@RequestBody Mark mark) {
        return this.markRepository.save(mark);
    }
}