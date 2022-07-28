package com.university.demo.services;

import com.university.demo.models.StudentCourse;

import java.util.List;

public interface IRegistrationService {
    StudentCourse registerStudentCourse (StudentCourse studentCourse);

    List<StudentCourse> getAllRegistration();
}
