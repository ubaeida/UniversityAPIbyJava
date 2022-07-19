package com.university.demo.services;

import com.university.demo.models.Student;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface IStudentService {

    Student saveStudent(Student student);

    List<Student> getStudents();

    Optional<Student> searchStudent(Long id);

    OptionalDouble studentGPA(Long studentId);

    void deleteStudent(Long id);
}
