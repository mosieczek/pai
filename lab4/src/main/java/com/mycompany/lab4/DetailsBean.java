/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4;

import java.io.Serializable;

/**
 *
 * @author ihate
 */
public class DetailsBean implements Serializable {
    private String code;
    private String name;
    private long population;
    private String continent;
    private String region;
    private Double surfacearea;
    private long indepyear;
    private Double lifeexpactancy;
    private Double gnp;
    private Double gnpoid;
    private String localname;
    private String governmentform;
    private String headofstate;
    private long capital;
    private String code2;
    
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public long getPopulation(){
        return population;
    }
    
    public void setPopulation(long population){
        this.population = population;
    }
    public String getContinent(){
        return continent;
    }
    
    public void setContinent(String continent){
        this.continent = continent;
    }
    public String getRegion(){
        return region;
    }
    
    public void setRegion(String region){
        this.region = region;
    }
    public Double getSurfacearea(){
        return surfacearea;
    }
    public void setSurfacearea(Double surfacearea){
        this.surfacearea = surfacearea;
    }
    public long getIdepyear(){
        return indepyear;
    }
    public void setIdepyear(long indepyear){
        this.indepyear = indepyear;
    }
    public Double getLifeexpactancy(){
        return lifeexpactancy;
    }
    public void setLifeexpactancy(Double lifeexpactancy){
        this.lifeexpactancy = lifeexpactancy;
    }
    public Double getGnp(){
        return gnp;
    }
    public void setGnp(Double gnp){
        this.gnp = gnp;
    }
    public Double getGnpoid(){
        return gnpoid;
    }
    public void setGnpoid(Double gnpoid){
        this.gnpoid = gnpoid;
    }
    public String getLocalname(){
        return localname;
    }
    public void setLocalname(String localname){
        this.localname = localname;
    }
    public String getGovernmentform(){
        return governmentform;
    }
    public void setGovernmentform(String governmentform){
        this.governmentform = governmentform;
    }
    public String getHeadofstate(){
        return headofstate;
    }
    public void setHeadofstate(String headofstate){
        this.headofstate = headofstate;
    }
    public long getCapital(){
        return capital;
    }
    public void setCapital(long capital){
        this.capital = capital;
    }
    public String getCode2(){
        return code2;
    }
    public void setCode2(String code2){
        this.code2 = code2;
    }
}
