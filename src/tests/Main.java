/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Adherant;
import entities.User;
import entities.Entraineur;
import services.AdherantService;
import services.EntraineurService;
import tools.MaConnexion;

/**
 *
 * @author Fayechi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaConnexion mc = MaConnexion.getInstance();
        
        Adherant p1 = new Adherant("1/12/1000", "Ben Ali", "ali","ghazela","emna611","1234567");
       AdherantService ps = new AdherantService();

        ps.ajouterAdherant(p1);
   //User A=p1;
        System.out.println(ps.afficherAdherant());;
          Entraineur p2 = new Entraineur("CDI","1/12/1000",12,7689, "Ben Ali", "ali","ghazela","emna611","1234567");
       EntraineurService ps1 = new EntraineurService();

        ps1.ajouterEntraineur(p2);
   
        System.out.println(ps1.afficherEntraineur());;
    }
    
}
