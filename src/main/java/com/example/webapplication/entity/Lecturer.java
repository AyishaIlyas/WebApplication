package com.example.webapplication.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lecturers")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(length = 45,nullable = false)

    private String lecId;

    @Column(length = 45,nullable = false)
    private String name;
    @Column(nullable = false,unique = true,length = 45)
    private String email;
    @Column(length = 15,nullable = false)
    private String password;
    @Column(nullable = false,unique = true,length = 255)
    private String course;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLecId() {
        return lecId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setLecId(String lecId){
        this.lecId=lecId;
    }

    public Lecturer(){

    }

    public Lecturer(String name, String email, String password, String lecId, String course) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.lecId=lecId;
        this.course=course;
    }

    @ManyToMany(mappedBy = "lecturers")
    private Set<Course> courses = new HashSet<>();
}
