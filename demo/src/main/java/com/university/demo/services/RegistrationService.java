package com.university.demo.services;

import com.university.demo.models.StudentCourse;
import com.university.demo.persistence.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService implements IRegistrationService {

    final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public StudentCourse registerStudentCourse(StudentCourse studentCourse) {
        return registrationRepository.save(studentCourse);
    }

    @Override
    public List<StudentCourse> getAllRegistration() {
        Iterable<StudentCourse> studentCourses = registrationRepository.findAll();
        List<StudentCourse> allRegistration = new ArrayList<>();
        for (StudentCourse studentCourse : studentCourses ){
            allRegistration.add(studentCourse);
        }
        return allRegistration;
    }

}
