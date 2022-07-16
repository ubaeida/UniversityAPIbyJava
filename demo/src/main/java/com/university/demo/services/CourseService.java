package com.university.demo.services;

import com.university.demo.models.Course;
import com.university.demo.persistence.CourseRepository;
import com.university.demo.validators.CourseValidators;

import java.util.ArrayList;
import java.util.List;

public class CourseService implements ICourseService {
    final CourseRepository courseRepository;
    final CourseValidators courseValidators;
    public CourseService(CourseRepository courseRepository, CourseValidators courseValidators) {
        this.courseRepository = courseRepository;
        this.courseValidators = courseValidators;
    }

    public Course saveCourse(Long cid, String name, int maxMark) {
        Course course = new Course(cid, name, maxMark);

        courseValidators.validate(course);

        return courseRepository.save(course);
    }
    public List<Course> getCourses(){
        Iterable<Course> courses= courseRepository.findAll();
        List<Course> listOfCourses = new ArrayList<>();
        for (Course course : courses){
            listOfCourses.add(course);
        }
        return listOfCourses;
    }
    //To do: Search course
}
