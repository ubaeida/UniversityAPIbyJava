package com.university.demo.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;

    @Email
    private String email;

    @NotNull
    private Gender gender;

    @OneToMany(mappedBy = "student")
    Set<StudentCourse> student_course;

    public Student(long id, String name, Gender gender, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long sid) {
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
