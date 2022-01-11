/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adzia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z]{2,30}",message="Podaj poprawne imie")
    private String name;
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z]{2,30}",message="Podaj poprawne nazwisko")
    private String surname;
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z]{2,30}",message="Podaj poprawny login")
    private String login;
    @Pattern(regexp = "[A-Za-z\\d@$!%./*#?&]{8,100}",message="Podaj poprawne hasło") //^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%./*#?&]{8,100}
    @NotEmpty(message="Podaj hasło")
    private String password;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public User() {
    }
    
    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }
}
