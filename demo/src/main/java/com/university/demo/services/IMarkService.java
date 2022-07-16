package com.university.demo.services;

import com.university.demo.models.Mark;

import java.util.List;

public interface IMarkService {
    Mark saveMark (Long studentId, Long courseId, int studentMark);
    List<Mark> getMarks();
}
