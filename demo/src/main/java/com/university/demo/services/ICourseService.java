package com.university.demo.services;

import com.university.demo.models.Course;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface ICourseService {
    Course saveCourse(Course course);

    List<Course> getCourses();

    Optional<Course> searchCourse(Long id);

    OptionalDouble courseAVG(Long id);

    void deleteCourse(Long id);
}