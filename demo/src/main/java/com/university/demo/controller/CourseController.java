package com.university.demo.controller;

import com.university.demo.models.Course;
import com.university.demo.persistence.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @RequestMapping("/course")
    @GetMapping
    Iterable<Course> getAllCourses(){
        return this.courseRepository.findAll();
    }

//    @RequestMapping("/course")
    @PostMapping
    Course addNewCourse(@RequestBody Course course){
        return this.courseRepository.save(course);
    }

//    @RequestMapping("/course")
    @GetMapping
    Optional<Course> getCourse(Long id){
        return this.courseRepository.findById(id);
    }
}