/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Agenda {

    ArrayList<RdV> agd;

    /*
    String nom;
    
     */
    //constructeur par défaut
    Agenda() {
        this.agd = null;
    }

    //constructeur surchargé
    Agenda(ArrayList<RdV> _agd) {
        this.agd.addAll(_agd);
    }

    //autres methodes
    
    /**
     * Ouvrir l'agenda d'une personne specifiee
     * ==> si boolean rappel == true; afficher le libelle du RdV dans un pop-up 15min avant
     */
    
    
    /**
     * sauvegarder ET fermer l'agenda
     */
    void FermerAgd(){
        
    }    
    
    /**
     * afficher tous les Rdvs (par date et horaires croissants) entre 2 dates
     */
    void afficherRdVs(LocalDate d1, LocalDate d2) {
        ArrayList <RdV> plage_RdV = new ArrayList();

        for (RdV elem_agenda : this.agd) {
            //si le rdv inscrit dans l'agenda est compris entre d1 et d2
            //d1<elem_agenda<d2 (OU d2<elem_agenda<d1 si d2<d1)
            if ((elem_agenda.getDate().isAfter(d1) && elem_agenda.getDate().isBefore(d2))
                    || (elem_agenda.getDate().isAfter(d2) && elem_agenda.getDate().isBefore(d1))) {
                plage_RdV.add(elem_agenda);
            }
        }
        System.out.printf("Entre le ", d1.getDayOfMonth(), "/", d1.getMonthValue(), "/",
                        d1.getYear(), " et le ", d2.getDayOfMonth(), "/", d2.getMonthValue(), "/",
                        d2.getYear());
        System.out.print("\n Vous avez les rdv suivants :\n");
        
        //TRIER plage_RdV par DATES et HORAIRES croissants !!!!!
        
        //on affiche la liste des rdv entre d1 et d2
        for(RdV elem : plage_RdV){
            System.out.println(elem.getLibelle());
            System.out.printf("%d", elem.getDate().getDayOfMonth(), " / %d", 
                    elem.getDate().getMonthValue(), " / %d", elem.getDate().getYear());

        }
    }

    /**
     * afficher les RdVs correspondant a un critere ou une conjonction de
     * criteres
     * ==> ici aussi il faut les afficher triés
     */
    
    
    /**
     * modifier un RdV (s'occcupe de l'affichage ET des modifs)
     */
    
    
    /**
     * ajouter un RdV (si le creneau date-horaire est libre)
     */
    void ajoutRdV(RdV _rdv) {
        for (RdV elem_agenda : this.agd) {
            //si le creneau est libre on ajoute le rdv dans l'agenda
            if(!(_rdv.getDate().equals(elem_agenda.getDate())
                    && (_rdv.getHdebut().isAfter(elem_agenda.getHdebut()) && _rdv.getHdebut().isBefore(elem_agenda.getHfin())
                    || _rdv.getHfin().isAfter(elem_agenda.getHdebut()) && _rdv.getHfin().isBefore(elem_agenda.getHfin())))) {
                this.agd.add(_rdv);
            }
        }
    }

    /**
     * supprimer un RdV
     */
    void suppressionRdV(RdV _rdv) {
        this.agd.remove(_rdv);
    }

    /**
     * supprimer TOUS les RdVs
     */
    void suppressionRdV_all() {
        //on vide l'agenda de ses elements
        for (RdV elem_agenda : this.agd) {
            this.agd.remove(elem_agenda);
        }
        //on reinitialise a null l'objet agenda
        this.agd = null;
    }

}