package com.university.demo.validators;

import com.university.demo.exception.MyValidationException;
import com.university.demo.models.Gender;
import com.university.demo.models.Student;
import com.university.demo.services.Validator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StudentValidator implements Validator<Student> {
    @Override
    public void validate(Student student) {
        List<String> errors = new ArrayList<String>();
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(student.getEmail());

        if (!matcher.matches()) {
            errors.add("Email in invalid");
        }
        if (!student.getGender().equals(Gender.values().toString())) {
            errors.add("Gender is invalid");
        }
        if (student.getName().equals("")) {
            errors.add("Name should not be empty");
        }
        if (student.getId() == 0) {
            errors.add("Student Id should not be empty");
        }
        if (!errors.isEmpty()) {
            throw new MyValidationException(errors);
        }
    }
}
