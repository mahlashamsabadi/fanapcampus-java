package com.example.jdbcsample.model;

public class Course {
    private Integer id;
    private String name;
    private Integer unit;

    public Course(Integer id, String name, Integer unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    public Course() {
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

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format("Course{id=%d, name=%s, unit=%d}",
                this.id,this.name,this.unit);
    }
}
