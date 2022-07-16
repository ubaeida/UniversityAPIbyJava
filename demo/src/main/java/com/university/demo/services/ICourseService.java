package com.university.demo.services;

import com.university.demo.models.Course;

import java.util.List;

public interface ICourseService {
    Course saveCourse(Long cid, String name, int maxMark);
    List<Course> getCourses();
}
