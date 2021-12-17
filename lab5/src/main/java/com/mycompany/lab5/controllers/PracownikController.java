/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5.controllers;

import com.mycompany.lab5.beans.Pracownik;
import com.mycompany.lab5.dao.PracownikDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ihate
 */
@Controller
public class PracownikController {
    @Autowired
    PracownikDao dao;
    
    @RequestMapping("/addForm")
    public String showform(Model m) {
        m.addAttribute("command", new Pracownik());
        return "addForm";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("pr") Pracownik pr) {
        dao.save(pr);
        return "redirect:/viewAll";
    }
    
    @RequestMapping("/viewAll")
    public String viewAll(Model m) {
        List<Pracownik> list = dao.getAll();
        m.addAttribute("list", list);
        return "viewAll";
    }
    
    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/viewAll";
    }
    
    @RequestMapping(value="/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Pracownik pr = dao.getPracownikById(id);
        m.addAttribute("command", pr);
        return "editForm";
    }
    
    @RequestMapping(value="/edit/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("pr") Pracownik pr) {
        dao.update(pr);
        return "redirect:/viewAll";
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    
}
