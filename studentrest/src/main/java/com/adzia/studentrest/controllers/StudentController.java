package com.adzia.studentrest.controllers;

import com.adzia.studentrest.entities.Student;
import com.adzia.studentrest.entities.StudentRepository;
import com.adzia.studentrest.services.StudentService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/students/all")
    public List<Student> getAll() {
        return studentService.getStudentList();
    }
    
    @PostMapping("/students/add")
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "students";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        Student student = studentRepository.findStudentById(id);
        if(student != null){
            studentService.deleteStudent(id);
            return "students";
        }
        return "Nie ma studenta o takim id";
        
    }
    
    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        Student currentStudent = studentRepository.findStudentById(id);

        if(currentStudent != null){
            currentStudent.setName(student.getName());
            currentStudent.setSurname(student.getSurname());
            currentStudent.setAvarage(student.getAvarage());
            studentRepository.save(currentStudent);
        }
        return "students";
    }
    
    @RequestMapping(value = "/")
    public String getRootContent() throws IOException {
        return getResource("C:\\Users\\Adriana Osmulska\\Documents\\pai\\studentrest\\src\\main\\resources\\static\\index.html");
    }

    private String getResource(String filePath) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(filePath));
        StringBuilder content = new StringBuilder();
        while (fileReader.hasNextLine()) {
            content.append(fileReader.nextLine());
        }
        return content.toString();
    }

}
