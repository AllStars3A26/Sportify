/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Personne;
import services.PersonneService;
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
        
        //Personne p1 = new Personne(7689, "Ben Ali", "ali");
        PersonneService ps = new PersonneService();
        //ps.ajouterPersonne2(p1);
        System.out.println(ps.afficherPersonne());;
    }
    
}
