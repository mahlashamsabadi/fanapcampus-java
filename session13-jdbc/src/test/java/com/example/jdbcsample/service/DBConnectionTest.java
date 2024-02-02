package com.example.jdbcsample.service;

import com.example.jdbcsample.model.Student;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionTest {
    private static DBConnection dbConnection;

    @BeforeClass
    public static void beforeClass() throws SQLException {
        dbConnection = new DBConnection();
        dbConnection.openConnection();
    }

    @Test
    public void selectStudentByID() throws SQLException {
        Student student = new Student();
        try (Statement statement = dbConnection.getConnection().createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("" +
                    "select * from student where sid=1");) {
                while (resultSet.next()) {
                    student.setId(resultSet.getInt("sid"));
                    student.setName(resultSet.getString("sname"));
                    student.setGpa(resultSet.getFloat("GPA"));
                }
            }
        }
        Assert.assertEquals("Ramin",student.getName());
        Assert.assertEquals((Float)19.0f , student.getGpa());
    }

    @Test
    public void getNumberOfStudentsWhoTakeACourse() throws SQLException {
        int count=0;
        try (Statement statement = dbConnection.getConnection().createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("" +
                    "select count(*) as numberOfStudents from register where cid=1");) {
                while (resultSet.next()) {
                    count= resultSet.getInt("numberOfStudents");
                }
            }
        }
        Assert.assertEquals(4, count);
    }

    @Test
    public void getNameOfStudentsWhoTakeACourseWithSpecificGrade() throws SQLException {
        List<String> nameOdStudents = new ArrayList<>();
        try (Statement statement = dbConnection.getConnection().createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("" +
                    "select s.sname as nameOfStudents from register r,student s" +
                    " where r.sid = s.sid and r.cid=1 and r.grade>15");) {
                while (resultSet.next()) {
                    String name= resultSet.getString("nameOfStudents");
                    nameOdStudents.add(name);
                }
            }
        }
        Assert.assertEquals(1, nameOdStudents.size());
        Assert.assertEquals("maryam", nameOdStudents.get(0).toLowerCase());
    }

    @Test
    public void getNumberOfStudentsInEachCourse() throws SQLException {
        List<Integer> numberOdStudents = new ArrayList<>();
        List<String> courseNames = new ArrayList<>();
        try (Statement statement = dbConnection.getConnection().createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("" +
                    "select c.cname , count(*) as numberOfStudents from register r, course c " +
                    "where r.cid = c.cid " +
                    "group by c.cname " +
                    "having count(*)>3");) {
                while (resultSet.next()) {
                    Integer numberOfStudent= resultSet.getInt("numberOfStudents");
                    String courseName = resultSet.getString("cname");
                    numberOdStudents.add(numberOfStudent);
                    courseNames.add(courseName);
                }
            }
        }
        Assert.assertEquals("mathematics" , courseNames.get(0).toLowerCase());
        Assert.assertEquals((Integer) 4, numberOdStudents.get(0));
        Assert.assertEquals("algorithm" , courseNames.get(1).toLowerCase());
        Assert.assertEquals((Integer) 5, numberOdStudents.get(1));
    }

    @Test
    public void insertNewStudent() throws SQLException {
        try(Statement statement = dbConnection.getConnection().createStatement();) {
            int affectedRows = statement.executeUpdate("insert into student (sid,sname,gpa) values (11,'mina',16)");
            Assert.assertEquals(1 , affectedRows);
        }
    }
    @Test
    public void updateStudent() throws SQLException {
        try(Statement statement = dbConnection.getConnection().createStatement();) {
            int affectedRows = statement.executeUpdate("update student set gpa = 20 where sid = 2");
            Assert.assertEquals(1 , affectedRows);
        }
    }
    @AfterClass
    public static void closeConnection() throws SQLException {
        dbConnection.closeConnection();
    }
}