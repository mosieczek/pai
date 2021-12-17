package com.mycompany.lab6v2.controllers;


import com.mycompany.lab6v2.entities.Zadanie;
import com.mycompany.lab6v2.repositories.ZadanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    
//    @RequestMapping("/listaZadan")
//    @ResponseBody
//    public String listaZadan() {
//    StringBuilder response = new StringBuilder();
//    Zadanie zadanie = new Zadanie();
//    //korzystając z obiektu repozytorium zapisujemy zadanie do bd
//    rep.save(zadanie);
//    //korzystając z obiektu repozytorium pobieramy wszystkie zadania z bd
//    for(Zadanie i: rep.findAll()) {
//        response.append(i).append("<br>");
//    }
//    return response.toString();
//    }
    
    @RequestMapping("/listaZadan")
    @ResponseBody
    public String listaZadan() {
        StringBuilder response = new StringBuilder();
        //korzystając z obiektu repozytorium pobieramy wszystkie zadania z bd
        for(Zadanie i: rep.findAll()) {
            response.append(i).append("<br>");
        }
        return response.toString();
    }
    @RequestMapping("/dodajZadania")
    public String dodajZadania() {
        Zadanie zadanie = new Zadanie();
        //korzystając z obiektu repozytorium zapisujemy zadanie do bd
        rep.save(zadanie);
        Zadanie z;
        double k=1000;
        boolean wyk=false;
        for(int i=1; i<10; i++) {
            z = new Zadanie();
            z.setNazwa("zadanie "+i);
            z.setOpis("Opis czynności do wykonania w zadaniu numer "+i);
            z.setKoszt(k);
            z.setWykonane(wyk);
            wyk=!wyk;
            k+=200.50;
            rep.save(z);
        }
        return "redirect:/listaZadan";
    }
    
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        rep.deleteById(id);
        return "redirect:/listaZadan";
    }
    
    @RequestMapping("wykonane/{wyk}")
    @ResponseBody
    public String kosztLess(@PathVariable boolean wyk) {
        StringBuilder response = new StringBuilder();
        rep.findByWykonane(wyk).forEach(i -> {
            response.append(i).append("<br>");
        });
        return response.toString();
    }
    
    @RequestMapping("kosztLess/{koszt}")
    @ResponseBody
    public String kosztLess(@PathVariable double koszt) {
        StringBuilder response = new StringBuilder();
        rep.findByKosztLessThan(koszt).forEach(i -> {
            response.append(i).append("<br>");
        });
        return response.toString();
    }
    
    @RequestMapping("kosztBetween/min/{min}/max/{max}")
    @ResponseBody
    public String kosztBetween(@PathVariable double min, @PathVariable double max) {
        StringBuilder response = new StringBuilder();
        rep.findByKosztBetween(min, max).forEach(i -> {
            response.append(i).append("<br>");
        });
        return response.toString();
    }


}
