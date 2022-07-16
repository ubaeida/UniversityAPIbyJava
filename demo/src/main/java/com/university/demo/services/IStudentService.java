package com.university.demo.services;

import com.university.demo.models.Gender;
import com.university.demo.models.Student;

import java.util.List;

public interface IStudentService {

    Student saveStudent(Long sid, String name, Gender gender, String email);
    List<Student> getStudents();
}
