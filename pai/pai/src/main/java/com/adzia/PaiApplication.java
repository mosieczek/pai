package com.adzia;

import com.adzia.dao.userDao;
import com.adzia.entity.User;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
        
//@ComponentScan({"com.adzia.controllers"})
@SpringBootApplication
public class PaiApplication {

    @Autowired
    private userDao dao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
            SpringApplication.run(PaiApplication.class, args);
    }
    
    @PostConstruct
    public void init() {
        dao.save(new User("Piotr", "Piotrowski","admin", 
        passwordEncoder.encode("admin")));
        dao.save(new User("Ania", "Annowska","ania",
        passwordEncoder.encode("ania")));
         dao.save(new User("ada", "ada","ada",
        passwordEncoder.encode("ada")));
    }

}
