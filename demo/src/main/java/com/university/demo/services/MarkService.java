package com.university.demo.services;

import com.university.demo.models.Mark;
import com.university.demo.persistence.MarkRepository;
import com.university.demo.validators.MarkValidators;

import java.util.ArrayList;
import java.util.List;

//class functionalValidator{
//    com.models.demo.student student;
//    com.models.demo.course course;
//
//    public List Validate(mark mark){
//     To be complicated
//    }
//}
public class MarkService implements IMarkService {

    final  MarkRepository markRepository;
    final MarkValidators markValidators;

    public MarkService(MarkRepository markRepository, MarkValidators markValidators) {
        this.markRepository = markRepository;
        this.markValidators = markValidators;
    }


    public Mark saveMark(Long sid, Long cid, int stuMark) {
        Mark mark = new Mark(sid, cid, stuMark);

        markValidators.validate(mark);

        return markRepository.save(mark);
    }

    public List<Mark> getMarks() {
        Iterable<Mark> marks = markRepository.findAll();
        List<Mark> listOfMarks = new ArrayList<>();
        for(Mark mark : marks){
            listOfMarks.add(mark);
        }
        return listOfMarks;
    }

    // To do: Student GPA, Get course AVG,
}
