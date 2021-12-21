/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adzia.controllers;

import com.adzia.dao.userDao;
import com.adzia.entity.User;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private userDao dao;
    @GetMapping("/login")
    public String loginPage() {
        //zwrócenie nazwy widoku logowania - login.html
        return "login";
    }
    @GetMapping("/register")
    public String registerPage(Model m) {
        //dodanie do modelu nowego użytkownika
        m.addAttribute("user", new User());
        //zwrócenie nazwy widoku rejestracji - register.html
        return "register";
    }
    @Valid
    @PostMapping("/register")
    public String registerPagePOST(@Valid @ModelAttribute(value = "user") User user, BindingResult binding) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        if (binding.hasErrors()) {
            return "register"; // powrót do formularza
        }
        dao.save(user);
        return "redirect:/login";
    }
    @GetMapping("/profile")
    public String profilePage(Model m, Principal principal) {
        //dodanie do modelu obiektu user - aktualnie zalogowanego użytkownika:
        m.addAttribute("user", dao.findByLogin(principal.getName()));
        //zwrócenie nazwy widoku profilu użytkownika - profile.html
        return "profile";
    }
    @GetMapping("/users")
    public String usersPage(Model m){
        m.addAttribute("userlist", dao.findAll());
        return "users";
    }
    @GetMapping("/delete/{id}")
    public String getUserId(@PathVariable Integer id, Model m, Principal principal) {
        dao.deleteById(id);
        m.addAttribute("userList", dao.findAll());
        
        if(dao.findByLogin(principal.getName()) == dao.findUserByUserid(id)){
            return "redirect:/logout";
        }
        else{
            return "redirect:/users";
        }
    }
    
    @GetMapping("/deleteprofile")
    public String getUserId(Principal principal) {
        dao.delete(dao.findByLogin(principal.getName()));
        return "redirect:/logout";
    }
    @GetMapping("/editprofile")
    public String editProfilePage(Model m, Principal principal) {
        //dodanie do modelu obiektu user - aktualnie zalogowanego użytkownika:
        m.addAttribute("user", dao.findByLogin(principal.getName()));
        //zwrócenie nazwy widoku profilu użytkownika - profile.html
        return "editprofile";
    }
    @Valid  
    @PostMapping("/editprofile/save")
    public String editProfilePost(@Valid @ModelAttribute(value = "user") User user, BindingResult binding, Principal principal) {
        User currentUser = dao.findByLogin(principal.getName());
        currentUser.setName(user.getName());
        currentUser.setSurname(user.getSurname());
        currentUser.setLogin(user.getLogin());
        currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
        if (binding.hasErrors()) {
            return "editprofile"; // powrót do formularza
        }
        dao.save(currentUser);
        return "redirect:/logout";
    }
}