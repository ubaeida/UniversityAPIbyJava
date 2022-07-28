package com.university.demo.services;

import com.university.demo.models.Mark;
import com.university.demo.persistence.MarkRepository;
import com.university.demo.validators.MarkValidators;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class MarkService implements IMarkService {

    final MarkRepository markRepository;
    final MarkValidators markValidators;

    public MarkService(MarkRepository markRepository, MarkValidators markValidators) {
        this.markRepository = markRepository;
        this.markValidators = markValidators;
    }

    @Override
    public Mark saveMark(Mark mark) {
        markValidators.validate(mark);
        return markRepository.save(mark);
    }

    @Override
    public List<Mark> getMarks() {
        Iterable<Mark> marks = markRepository.findAll();
        List<Mark> listOfMarks = new ArrayList<>();
        for (Mark mark : marks) {
            listOfMarks.add(mark);
        }
        return listOfMarks;
    }

    @Override
    @Transactional
    public void deleteMark(Long id) {
        if (markRepository.existsById(id)) {
            markRepository.deleteById(id);
        }
    }
}