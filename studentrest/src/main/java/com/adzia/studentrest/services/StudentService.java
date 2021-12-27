/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adzia.studentrest.services;

import com.adzia.studentrest.entities.Student;
import com.adzia.studentrest.entities.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getStudentList(){
        return (List<Student>) studentRepository.findAll();
    }
    
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    
    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
    
    public void getStudent(int id){
        studentRepository.findStudentById(id);
        
    }
    
}
