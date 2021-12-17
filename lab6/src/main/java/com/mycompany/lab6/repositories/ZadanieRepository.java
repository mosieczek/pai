/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6.repositories;

import com.mycompany.lab6.entities.Zadanie;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ihate
 */
public interface ZadanieRepository extends CrudRepository<Zadanie, Long> {
    //save(Zadanie t);
    Zadanie findOne(Long id);

    long count();
    void deleteById(Long id);
    void delete(Zadanie r);
    //deleteAll();
}
