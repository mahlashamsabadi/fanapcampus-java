package com.example.jdbcsample.model;

public class Student {
    private Integer id;
    private String name;
    private Float gpa;

    public Student(Integer id, String name, Float gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d , name=%s, gpa=%f}",this.id,this.name,this.gpa);
    }
}
