package com.university.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private long courseId;
    private int studentMark;

    public Mark(long studentId, long courseId, int studentMark) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.studentMark = studentMark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mark() {

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public int getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(int studentMark) {
        this.studentMark = studentMark;
    }

    @Override
    public String toString() {
        return "mark{" +
                "sid=" + studentId +
                ", cid=" + courseId +
                ", stuMark=" + studentMark +
                '}';
    }
}
