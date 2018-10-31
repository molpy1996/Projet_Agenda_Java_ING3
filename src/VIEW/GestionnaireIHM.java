/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;



import java.util.Scanner;

/**
 *
 * @author asus
 */
public class GestionnaireIHM {
    
    public GestionnaireIHM()
    {
  
        //Variables 
        int choix;
        int choix1;
        
        Scanner s = new Scanner(System.in);
        
     do
     {
        System.out.println();
        System.out.println("******************* MENU *******************");
        System.out.println("            (1) --> Menu 1  ");
        System.out.println("            (2) --> Menu 2  ");
        System.out.println("*******************************************");
            
        System.out.println();
        System.out.println();
        System.out.println("#### VOTRE CHOIX #### ");
        choix=s.nextInt();
        
        
        
        switch (choix)
        {
        
            case 1:
        {
            System.out.println();
            System.out.println("******************* MENU 1 *******************");
            System.out.println("     (1) --> Creer un nouvel agenda  ");
            System.out.println("     (2) --> Ouvrir un agenda existant  ");
            System.out.println("     (3) --> Quitter        ");
            System.out.println("*******************************************");
            System.out.println();
            System.out.println();
            System.out.println("#### VOTRE CHOIX #### ");
            choix1=s.nextInt();
            switch (choix1)
            {
                case 1 :
                {
                    //creation d'agenda
                }
                
                case 2:
                {
                    //charger un agenda
                }
                
                case 3:
                {
                    //retour au menu principal
                    GestionnaireIHM M = new GestionnaireIHM();
                }
                
                default:
                {
                    System.out.println();
                    System.out.println();
                    System.out.println("#### VOTRE CHOIX #### ");
                }
            }
            break;
        }
            case 2:
        {
            System.out.println();
            System.out.println("******************* MENU 2 *******************");
            System.out.println("     (1) --> Afficher tous les Rdv entre 2 dates  ");
            System.out.println("     (2) --> Afficher les Rdv filtrés sur critere(s)  ");
            System.out.println("     (3) --> Modifier un Rdv        ");
            System.out.println("     (4) --> Supprimer un Rdv        ");
            System.out.println("     (5) --> Supprimer tous les Rdv        ");
            System.out.println("     (6) --> Sauvegarder & fermer l'agenda        ");
            System.out.println("*******************************************");
            choix1=s.nextInt();
            switch (choix1)
            {
                case 1 :
                {
                    //afficher tous les Rdv
                }
                
                case 2:
                {
                    //Afficher les Rdv filtré
                }
                
                case 3:
                {
                    //retour au menu principal
                    GestionnaireIHM M = new GestionnaireIHM();
                }
                
                default:
                {
                    System.out.println();
                    System.out.println();
                    System.out.println("#### VOTRE CHOIX #### ");
                }
            }
            break;
            }
        
            default : 
            {
                System.out.println();
                System.out.println();
                System.out.println("################################################");
                System.out.println("##################### ERREUR ###################");
                System.out.println("################################################");
                System.out.println();
                System.out.println();
            }
        }
     } while(choix!=1 && choix!=2);
    }
        
}
    

