package com.university.demo.validators;

import com.university.demo.exception.MyValidationException;
import com.university.demo.models.Mark;
import com.university.demo.services.Validator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarkValidators implements Validator<Mark> {

    @Override
    public void validate(Mark mark) {

        List<String> errors = new ArrayList<String>();
        if (mark.getCourseId() == 0) {
            errors.add("Course Id should not be empty");
        }
        if (mark.getStudentId() == 0) {
            errors.add("Student Id should not be empty");
        }
        if (mark.getStudentMark() < 0 || mark.getStudentMark() > 100) {
            errors.add("Student mark should not be between 0 and 100");
        }
        if (!errors.isEmpty()) {
            throw new MyValidationException(errors);
        }
    }

}
