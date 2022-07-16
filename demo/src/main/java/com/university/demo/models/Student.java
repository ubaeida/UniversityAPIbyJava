package com.university.demo.models;


public class Student {
    private long id;
    private String name;
    private String email;

    private Gender gender;


    public Student(long id, String name, Gender gender, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public long getSid() {
        return id;
    }

    public void setSid(long sid) {
        this.id = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", gender='" + gender + '\'' + '}';
    }
}
