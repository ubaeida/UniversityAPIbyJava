package com.university.demo.persistence;

import com.university.demo.models.StudentCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends CrudRepository<StudentCourse, Long> {
}
