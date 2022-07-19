package com.university.demo.services;

import com.university.demo.models.Mark;

import java.util.List;

public interface IMarkService {
    Mark saveMark(Mark mark);

    List<Mark> getMarks();

    void deleteMark(Long id);
}
