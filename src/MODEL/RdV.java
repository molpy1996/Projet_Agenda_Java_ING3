/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Victor BRIERE
 */
public class RdV {
    private LocalDate date;
    private LocalTime h_debut;
    private LocalTime h_fin;
    private String libelle;
    private boolean rappel;
    
    //constructeur par défaut
    RdV(){
        this.date=LocalDate.parse("0000-00-00");
        this.h_debut=LocalTime.parse("00:00");
        this.h_fin=LocalTime.parse("00:00");
        this.libelle=null;
        this.rappel=false;
    }
    
    //constructeur surchargé
    RdV(LocalDate _date, LocalTime _h_debut, LocalTime _h_fin, String _libelle, 
            boolean _rappel){
        
    }
    
    //getters
    LocalDate getDate(){
        return this.date;
    }
    
    LocalTime getHdebut(){
        return this.h_debut;
    }
    
    LocalTime getHfin(){
        return this.h_fin;
    }
    
    String getLibelle(){
        return this.libelle;
    }
    
    boolean getRappel(){
        return this.rappel;
    }
    
    //setters
    
    void setDate(LocalDate _date){
        this.date=_date;
    }
    
    void setHdebut(LocalTime _h_debut){
        this.h_debut=_h_debut;
    }
    
    void setHfin(LocalTime _h_fin){
        this.h_fin=_h_fin;
    }
    
    void setLibelle(String _libelle){
        if(_libelle.length()<=30){
        this.libelle=_libelle;
        }
    }
    
    void setRappel(boolean _rappel){
        this.rappel=_rappel;
    }
    
    //autres methodes
    
}
