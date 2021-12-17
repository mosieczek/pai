/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6v2.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Zadanie {
    @GeneratedValue
    @Id
    private Long id;
    
    @Column
    private String nazwa;
    
    @Column
    @Lob
    private String opis;
    
    @Column
    private Double koszt;
    @Column
    private Boolean wykonane=false;
    
    public Zadanie() {
        this.koszt = 2000.0;
        this.nazwa="Zadanie";
        this.opis="Zadanie do wykonania";
    }
    //nadpisana metoda toString
    @Override
    public String toString() {
        return "Encja Zadanie{ id=" + id + ", " + nazwa + ", " + opis +
        ", koszt=" + koszt + ", wykonane=" + wykonane + "}";
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getKoszt() {
        return koszt;
    }

    public void setKoszt(Double koszt) {
        this.koszt = koszt;
    }

    public Boolean getWykonane() {
        return wykonane;
    }

    public void setWykonane(Boolean wykonane) {
        this.wykonane = wykonane;
    }
    
    
}
