package com.university.demo.services;

import com.university.demo.models.Gender;
import com.university.demo.models.Student;
import com.university.demo.persistence.StudentRepository;
import com.university.demo.validators.StudentValidator;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {

    final StudentRepository studentRepository;
    final StudentValidator studentValidator;

    public StudentService(StudentRepository repository, StudentValidator studentValidator) {
        this.studentRepository = repository;
        this.studentValidator = studentValidator;
    }


    public Student saveStudent(Long sid, String name, Gender gender, String email) {
        Student student = new Student(sid, name, gender, email);

        studentValidator.validate(student);

        return studentRepository.save(student);
    }

    public List<Student> getStudents(){
        Iterable<Student> students= studentRepository.findAll();
        List<Student> listOfStudents = new ArrayList<>();
        for (Student student : students){
            listOfStudents.add(student);
        }
        return listOfStudents;
    }
    //To do: Search Student
}
