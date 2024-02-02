package com.example.jdbcsample.model;

public class Register {
    private Integer studentId;
    private Integer courseId;
    private Float grade;

    public Register(Integer studentId, Integer courseId, Float grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public Register() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("Register{studentId=%d, courseId=%d, grade=%f}",
                this.courseId,this.studentId,this.grade);
    }
}
