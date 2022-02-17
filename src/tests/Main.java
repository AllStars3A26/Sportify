/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import tools.MaConnexion;
import entities.Cours;
import services.CoursService;
import entities.Seance;
import services.SeanceService;


/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MaConnexion mc = MaConnexion.getInstance();
        Cours c1 = new Cours(0,"attaque","mehrez","cardio + musculation","physique +endurance");
        Cours c2 = new Cours(0,"defense","mehrez","cardio","physique + souplesse");
        Seance s1 = new Seance(0, "30/12/2002","12:59","mulin","mehrez");
        Seance s2 = new Seance(0, "453452","13","mulin","ahmed");
        //Personne p1 = new Personne(7689, "Ben Ali", "ali");
        //Personne p2 = new Personne(7689, "Ben helmi", "helmi");
        CoursService cs = new CoursService();
        SeanceService ss = new SeanceService();
        //PersonneService ps = new PersonneService();
        cs.ajouterCour(c1);
        cs.ajouterCour(c2);
        ss.ajouterSeance(s1);
        //ss.ModifierC("12/12/2002","13:00","mulin","mehrez");
        //ss.SupprimerParnom("mehrez","12/12/2002");
        //ss.ajouterSeance(s2);
        //ps.ajouterPersonne2(p2);
        //Cours.ModifierC("defense","lakhdher","cardio op","souplesse");
        //System.out.println(ss.afficherSeance());
      //System.out.println(cs.afficherCours());
    }
    
}
