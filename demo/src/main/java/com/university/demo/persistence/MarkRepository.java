package com.university.demo.persistence;

import com.university.demo.models.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Long> {
    List<Mark> findAllByStudentId(long studentId);
    List<Mark> findAllByCourseId (long courseId);
    List<Mark> deleteAllByStudentId(long studentId);
    List<Mark> deleteAllByCourseId(long courseId);
}
