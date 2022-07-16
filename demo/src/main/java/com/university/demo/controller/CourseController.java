package com.university.demo.controller;


import com.university.demo.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

interface CourseRepository extends CrudRepository<Course, Long>{}

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @GetMapping
    Iterable<Course> getAllCourses(){
        return this.courseRepository.findAll();
    }
    @PostMapping
    Course addNewCourse(@RequestBody Course course){
        return this.courseRepository.save(course);
    }

    @GetMapping
    Optional<Course> getCourse(Long id){
        return this.courseRepository.findById(id);
    }
}