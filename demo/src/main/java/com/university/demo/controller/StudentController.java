package com.university.demo.controller;

import com.university.demo.models.Student;
import com.university.demo.services.StudentService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    Iterable<Student> getAllStudents() {
        return this.studentService.getStudents();
    }

    @PostMapping
    Student addNewStudent(@RequestBody Student student) {
        return this.studentService.saveStudent(student);
    }

    @RequestMapping("{id}")
    @GetMapping
    Optional<Student> getStudent(@PathVariable Long id)
    {
        return this.studentService.searchStudent(id);
    }


    @RequestMapping("{id}/gpa")
    @GetMapping
    public OptionalDouble getStudentGPA(@PathVariable Long id) {
        return studentService.studentGPA(id);
    }

    @RequestMapping("{id}/delete")
    @GetMapping
    @Transactional
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}