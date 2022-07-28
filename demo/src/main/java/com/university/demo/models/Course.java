package com.university.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;

    @Min(100)
    @Max(100)
    private int maxMark;

    @OneToMany(mappedBy = "course")
    Set<StudentCourse> student_course;

    public Course(long id, String name, int maxMark) {
        this.id = id;
        this.name = name;
        this.maxMark = maxMark;
    }

    public Course() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(int maxMark) {
        this.maxMark = maxMark;
    }

    @Override
    public String toString() {
        return "course{" +
                "cid=" + id +
                ", name='" + name + '\'' +
                ", maxMark=" + maxMark +
                '}';
    }
}
