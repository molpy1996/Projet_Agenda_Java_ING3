/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;

/**
 *
 * @author Victor Brière
 */
public class Agenda {

    ArrayList<RdV> agd = null;

    /*
    String nom;
    
     */
    //constructeur par défaut
    public Agenda() {
        this.agd = null;
    }

    //constructeur surchargé
    public Agenda(ArrayList<RdV> _agd) {
        this.agd = new <RdV> ArrayList();
        this.agd.addAll(_agd);
    }

    //getter
    public ArrayList<RdV> getAgenda() {
        return this.agd;
    }

    //autres methodes
    
    /**
     * Ouvrir l'agenda d'une personne specifiee ==> si boolean rappel == true;
     * afficher le libelle du RdV dans un pop-up 15min avant
     */
    
    
    /**
     * sauvegarder l'agenda dans un fichier ET fermer l'agenda
     */
    
    
    public void FermerAgd() {
        //on essaye d'ouvrir un fichier dans lequel enregistrer le contenu de l'agenda
        try {
            Formatter f_agenda = new Formatter("\\Projet_Agenda_ING3\\saved_agendas");

            for (RdV el : this.getAgenda()) {
                //on enregistre 1 rdv par ligne
                //faire gaffe aux formats : %..
                f_agenda.format("%s/%s/%s de %s a %s : %s , %b",
                        el.getDate().getDayOfMonth(), el.getDate().getMonthValue(),
                        el.getDate().getYear(), el.getHdebut(),
                        el.getHfin(), el.getLibelle(), el.getRappel());
                //on supprime le rdv de l'arraylist d'agenda    
                this.suppressionRdV(el);
            }
            //on ferme le fichier en ecriture
            f_agenda.close();
            //on met l'attribut agenda à null une fois qu'il est "vidé"
            this.agd = null;
        } //en cas de probleme dans l'ouverture du fichier on affiche une erreur
        catch (Exception e) {
            System.out.print("Erreur d'ouverture du fichier\n");
        }

    }

    /**
     * retourne tous les Rdvs (par date et horaires croissants) entre 2 dates
     *
     * @param d1
     * @param d2
     * @return
     */
    public ArrayList<RdV> afficherRdV(LocalDate d1, LocalDate d2) {
        ArrayList<RdV> plage_RdV = new ArrayList();
        if (this.getAgenda() != null) {
            for (RdV elem_agenda : this.getAgenda()) {
                //si le rdv inscrit dans l'agenda est compris entre d1 et d2
                //d1<elem_agenda<d2 (OU d2<elem_agenda<d1 si d2<d1)
                if ((elem_agenda.getDate().isAfter(d1) && elem_agenda.getDate().isBefore(d2))
                        || (elem_agenda.getDate().isAfter(d2) && elem_agenda.getDate().isBefore(d1))) {
                    plage_RdV.add(elem_agenda);
                }
            }
            //on print la liste de rdv avant tri
            System.out.print(plage_RdV);
            //on print la liste de rdv avant tri
            System.out.print("\n");
            Collections.sort(plage_RdV);
            System.out.print(plage_RdV);

        }

        return plage_RdV;

    }

    /**
     * renvoyer une arrayList des RdVs correspondant a un critere ou une
     * conjonction de criteres
     *
     */
    
    /**
     * modifier un RdV (s'occcupe pas de l'affichage)
     */
    public void modifierRdV() {

    }
    

    /**
     * ajouter un RdV (si le creneau date-horaire est libre)
     *
     * @param _rdv
     */
    public void ajoutRdV(RdV _rdv) {
        for (RdV elem_agenda : this.getAgenda()) {
            //si le creneau est libre on ajoute le rdv dans l'agenda
            if (!(_rdv.getDate().equals(elem_agenda.getDate())
                    && (_rdv.getHdebut().isAfter(elem_agenda.getHdebut()) && _rdv.getHdebut().isBefore(elem_agenda.getHfin())
                    || _rdv.getHfin().isAfter(elem_agenda.getHdebut()) && _rdv.getHfin().isBefore(elem_agenda.getHfin())))) {
                this.getAgenda().add(_rdv);
            }
        }
    }

    
    /**
     * supprimer un RdV
     *
     * @param _rdv
     */
    public void suppressionRdV(RdV _rdv) {
        //on supprime un rdv de l'agenda
        this.getAgenda().remove(_rdv);
        //on reinitialise a null l'objet rdv
        _rdv = null;
    }
    

    /**
     * supprimer TOUS les RdVs
     */
    public void suppressionRdV_all() {
        //on vide l'agenda de ses elements
        for (RdV elem_agenda : this.agd) {
            this.getAgenda().remove(elem_agenda);
        }
        //on reinitialise a null l'objet agenda
        this.agd = null;
    }

}
