package com.university.demo.controller;


import com.university.demo.models.StudentCourse;
import com.university.demo.services.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    Iterable<StudentCourse> registerStudentCourse(){
        return registrationService.getAllRegistration();
    }

    @PostMapping
    StudentCourse registerStudentCourse(@RequestBody StudentCourse studentCourse){
        return registrationService.registerStudentCourse(studentCourse);
    }
}
