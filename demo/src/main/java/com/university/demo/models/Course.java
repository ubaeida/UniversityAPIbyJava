package com.university.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int maxMark;

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
