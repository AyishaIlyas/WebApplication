package com.example.webapplication.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(length = 45,nullable = false)
    private String studentId;
    @Column(length = 45,nullable = false)
    private String firstName;
    @Column(length = 45,nullable = false)
    private String lastName;
    @Column(nullable = false,unique = true,length = 45)
    private String email;
    @Column(length = 15,nullable = false)
    private String password;
    @Column(nullable = false,unique = true,length = 255)
    private String course;
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private boolean enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCourses() {
        return course;
    }

    public void setCourses(String course) {
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Student(){

    }

    public Student(String firstName, String lastName, String email, String password,String studentId, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.studentId=studentId;
        this.course=course;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                '}';
    }

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();
}
