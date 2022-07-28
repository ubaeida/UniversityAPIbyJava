package com.university.demo.controller;

import com.university.demo.models.Mark;
import com.university.demo.services.MarkService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marks")
public class MarkController {
    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping
    Iterable<Mark> getAllMarks() {
        return markService.getMarks();
    }

    @PostMapping
    Mark addNewMark(@RequestBody Mark mark) {
        return this.markService.saveMark(mark);
    }

    @RequestMapping("{id}/delete")
    @GetMapping
    public void deleteMark(@PathVariable Long id){
        markService.deleteMark(id);
    }
}