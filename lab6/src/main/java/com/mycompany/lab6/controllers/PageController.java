package com.mycompany.lab6.controllers;

import com.mycompany.lab6.entities.Zadanie;
import com.mycompany.lab6.repositories.ZadanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class PageController {
    
    @Autowired
    public ZadanieRepository rep;

    @RequestMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Hello Spring Boot from mainPage() method!";
    }
    
    @RequestMapping("/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hello Spring Boot from pageTwo() method!";
    }
    
    @RequestMapping("/listaZadan")
    @ResponseBody
    public String listaZadan() {
    StringBuilder response = new StringBuilder();
    Zadanie zadanie = new Zadanie();
    //korzystając z obiektu repozytorium zapisujemy zadanie do bd
    rep.save(zadanie);
    //korzystając z obiektu repozytorium pobieramy wszystkie zadania z bd
    for(Zadanie i: rep.findAll()) {
        response.append(i).append("<br>");
    }
    return response.toString();
    }


}
