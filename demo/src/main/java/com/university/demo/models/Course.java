package com.university.demo.models;

public class Course {
    private long id;
    private String name;
    private int maxMark;

    public Course(long id, String name, int maxMark) {
        this.id = id;
        this.name = name;
        this.maxMark = maxMark;
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
