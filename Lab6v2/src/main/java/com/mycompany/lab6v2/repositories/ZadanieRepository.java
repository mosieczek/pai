/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6v2.repositories;


import com.mycompany.lab6v2.entities.Zadanie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ihate
 */
public interface ZadanieRepository extends CrudRepository<Zadanie, Long> {
    public List<Zadanie> findByWykonane(boolean wyk);
    public List<Zadanie> findByKosztLessThan(double koszt);
    public List<Zadanie> findByKosztBetween(double min, double max);
}
