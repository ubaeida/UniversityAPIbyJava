package com.university.demo.persistence;

import com.university.demo.models.Mark;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends CrudRepository<Mark, Long> {

}
