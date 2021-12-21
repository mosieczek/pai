package com.adzia.studentrest.controllers;

import com.adzia.studentrest.entities.Student;
import com.adzia.studentrest.services.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/students")
    public List<Student> getAll() {
        return studentService.getStudentList();
    }
    
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
}
