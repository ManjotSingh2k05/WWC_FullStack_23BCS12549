package com.example.studentCourseRegisteration.model;

public class Student {
    int id;
    String name;
    String course;

    Student(){};

    Student(int id, String name, String course){
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public  int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCourse(){
        return  this.course;
    }

    public void setCourse(String course){
        this.course = course;
    }
}
