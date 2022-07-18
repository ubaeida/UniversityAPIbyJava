package com.university.demo.models;

import javax.persistence.*;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Long courseId;
    private int studentMark;


    public Mark(Long studentId, Long courseId, int studentMark) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.studentMark = studentMark;
    }

    public Mark() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
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
                ", cid=" + courseId +
                ", stuMark=" + studentMark +
                '}';
    }
}
