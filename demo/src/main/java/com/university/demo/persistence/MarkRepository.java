package com.university.demo.persistence;

import com.university.demo.models.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Long> {

}
