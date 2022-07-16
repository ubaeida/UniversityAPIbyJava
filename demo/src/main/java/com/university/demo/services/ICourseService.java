package com.university.demo.services;

import com.university.demo.models.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    Course saveCourse(Long id, String name, int maxMark);

    List<Course> getCourses();
    Course searchCourse(Long id);
}
