package com.university.demo.controller;

import com.university.demo.models.Course;
import com.university.demo.services.ICourseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    Iterable<Course> getAllCourses() {
        return this.courseService.getCourses();
    }

    @PostMapping
    Course addNewCourse(@RequestBody @Valid Course course) {
        return this.courseService.saveCourse(course);
    }

    @RequestMapping("{id}")
    @GetMapping
    Optional<Course> getCourse(@PathVariable Long id) {
        return this.courseService.searchCourse(id);
    }

    @RequestMapping("{id}/avg")
    @GetMapping
    OptionalDouble getCourseAVG(@PathVariable Long id) {
        return this.courseService.courseAVG(id);
    }

    @RequestMapping("{id}/delete")
    @GetMapping
    public void deleteStudent(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
