package com.university.demo.controller;
import com.university.demo.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

interface StudentRepository extends CrudRepository <Student, Long >{}
@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping
    Iterable<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }

    @PostMapping
    Student addNewStudent(@RequestBody Student student){
        return this.studentRepository.save(student);
    }
}