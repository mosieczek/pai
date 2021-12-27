/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adzia.studentrest.entities;

import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Student {
    
    public Student() { }
    public Student(String name) {
        this.name = name;
    }
    
        public Student(String name, String surname, Double avarage) {
        this.name = name;
        this.surname = surname;
        this.avarage = avarage;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;
    @JsonView
    @Getter
    @Setter
    private String name;
    @JsonView
    @Getter
    @Setter
    private String surname;
    @JsonView
    @Getter
    @Setter
    private Double avarage;
}
