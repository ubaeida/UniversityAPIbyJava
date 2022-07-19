package com.university.demo.services;

import com.university.demo.exception.MyValidationExceptionHandler;
import com.university.demo.models.Mark;
import com.university.demo.models.Student;
import com.university.demo.persistence.MarkRepository;
import com.university.demo.persistence.StudentRepository;
import com.university.demo.validators.StudentValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class StudentService implements IStudentService {

    final StudentRepository studentRepository;
    final StudentValidator studentValidator;
    final MarkRepository markRepository;

    public StudentService(StudentRepository repository, StudentValidator studentValidator, MarkRepository markRepository) {
        this.studentRepository = repository;
        this.studentValidator = studentValidator;
        this.markRepository = markRepository;
    }


    public Student saveStudent(Student student) {

        studentValidator.validate(student);

        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        Iterable<Student> students = studentRepository.findAll();
        List<Student> listOfStudents = new ArrayList<>();
        for (Student student : students) {
            listOfStudents.add(student);
        }
        return listOfStudents;
    }

    public Optional<Student> searchStudent(Long id) {
        return this.studentRepository.findById(id);
    }

    public OptionalDouble studentGPA(Long studentId) {
        var marks = markRepository.findAllByStudentId(studentId);
        return marks.stream().map(Mark::getStudentMark).mapToDouble(Double::valueOf).average();
    }

    public void deleteStudent(Long id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            markRepository.deleteAllByStudentId(id);
    }
    }
}