package com.university.demo.controller;

import com.university.demo.models.Student;
import com.university.demo.persistence.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/student")
    @GetMapping
    Iterable<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @PostMapping
    Student addNewStudent(@RequestBody Student student) {
        return this.studentRepository.save(student);
    }

    @GetMapping
    Optional<Student> getStudent(Long id) {
        return this.studentRepository.findById(id);
    }
}