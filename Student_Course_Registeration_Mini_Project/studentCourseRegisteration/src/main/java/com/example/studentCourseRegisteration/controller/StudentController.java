package com.example.studentCourseRegisteration.controller;

import com.example.studentCourseRegisteration.model.Student;
import com.example.studentCourseRegisteration.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {

        int status = service.register(student);

        if (status == 400) {
            return ResponseEntity.badRequest().body("Name or Course empty.");
        }

        if (status == 409) {
            return ResponseEntity.status(409).body("Student ID: " + student.getId() + " already exists.");
        }

        return ResponseEntity.status(201).body("Stu registered.");
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        Student student = service.getStudentById(id);

        if (student == null) {
            return ResponseEntity.status(404).body("Stu ID " + id + " not found.");
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {

        boolean deleted = service.deleteById(id);

        if (!deleted) {
            return ResponseEntity.status(404).body("Student not found.");
        }

        return ResponseEntity.ok("Student deleted.");
    }
}
