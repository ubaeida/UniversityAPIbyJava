package com.university.demo.services;

import com.university.demo.models.Course;
import com.university.demo.persistence.CourseRepository;
import com.university.demo.validators.CourseValidators;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseService implements ICourseService {
    final CourseRepository courseRepository;
    final CourseValidators courseValidators;

    public CourseService(CourseRepository courseRepository, CourseValidators courseValidators) {
        this.courseRepository = courseRepository;
        this.courseValidators = courseValidators;
    }

    public Course saveCourse(Long id, String name, int maxMark) {
        Course course = new Course(id, name, maxMark);

        courseValidators.validate(course);

        return courseRepository.save(course);
    }

    public List<Course> getCourses() {
        Iterable<Course> courses = courseRepository.findAll();
        List<Course> listOfCourses = new ArrayList<>();
        for (Course course : courses) {
            listOfCourses.add(course);
        }
        return listOfCourses;
    }

    public Course searchCourse(Long id) {
        if  (this.courseRepository.findById(id).isEmpty()){
            return null;
        }else {
            return  this.courseRepository.findById(id).get();
        }
    }
}
