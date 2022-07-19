package com.university.demo.validators;

import com.university.demo.exception.MyValidationException;
import com.university.demo.models.Course;
import com.university.demo.services.Validator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseValidators implements Validator<Course> {

    @Override
    public void validate(Course course) {
        List<String> errors = new ArrayList<>();
        if (course.getName().equals("")) {
            errors.add("Course name should not be empty");
        }
        if (course.getMaxMark() != 100) {
            errors.add("Course max mark should be equals to 100");
        }
        if (!errors.isEmpty()) {
            throw new MyValidationException(errors);
        }

    }
}
