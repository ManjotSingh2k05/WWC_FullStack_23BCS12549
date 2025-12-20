package com.example.studentCourseRegisteration.service;

import com.example.studentCourseRegisteration.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {
    public List<Student> studentList = new ArrayList<>();

    public int register(Student s){
        if(s.getName().isEmpty() || s.getCourse().isEmpty()){
            return 400;
        }

        for(Student list : studentList){
            if(s.getId() == list.getId()){
                return 409;
            }
        }

        studentList.add(s);
        return 201;
    }

    public List getAllStudents(){

        return studentList;
    }

    public Student getStudentById(int studentId){

        for(Student list : studentList){
            if(studentId == list.getId()){

                return list;
            }
        }

        return null;
    }

    public boolean deleteById(int studentId){

        Iterator<Student> it = studentList.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.getId() == studentId) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }

}
