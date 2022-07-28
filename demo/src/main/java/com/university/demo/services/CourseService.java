package com.university.demo.services;

import com.university.demo.models.Course;
import com.university.demo.models.Mark;
import com.university.demo.persistence.CourseRepository;
import com.university.demo.persistence.MarkRepository;
import com.university.demo.validators.CourseValidators;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class CourseService implements ICourseService {
    final CourseRepository courseRepository;
    final CourseValidators courseValidators;
    final MarkRepository markRepository;

    public CourseService(CourseRepository courseRepository, CourseValidators courseValidators, MarkRepository markRepository) {
        this.courseRepository = courseRepository;
        this.courseValidators = courseValidators;
        this.markRepository = markRepository;
    }

    public Course saveCourse(Course course) {

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

    public Optional<Course> searchCourse(Long id) {
        return this.courseRepository.findById(id);
    }

    public OptionalDouble courseAVG(Long id) {
        var marks = markRepository.findAllByCourseId(id);
        return marks.stream().map(Mark::getStudentMark).mapToDouble(Double::valueOf).average();
    }
    @Transactional
    public void deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            markRepository.deleteAllByCourseId(id);
        }
    }
}