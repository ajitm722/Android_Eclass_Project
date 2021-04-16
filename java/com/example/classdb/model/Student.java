package com.example.classdb.model;

import java.io.Serializable;

public class Student implements Serializable {

    int id;
    String name;
    String course;
    String rollno;
    int total;
    int paid;

    public Student(int id, String name, String course, String rollno, int total, int paid) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.rollno = rollno;
        this.total = total;
        this.paid = paid;
    }

    public Student(String name, String course, String rollno, int total, int paid) {
        this.name = name;
        this.course = course;
        this.rollno = rollno;
        this.total = total;
        this.paid = paid;
    }

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }
}
