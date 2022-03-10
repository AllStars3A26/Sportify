/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import tools.MaConnexion;
import Services.UtilisateurService;
import Entities.Utilisateur;
import Entities.Entraineur;
import Entities.Adhérent;
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
        Utilisateur U = new Utilisateur(0, "amir", "amir", "amir", "amir","amir", "amir@gmail.com");
        Adhérent A = new Adhérent("wejdi", "wejdi", "wejdi","wejdi","wejdi", 1, null,null, null);
        Entraineur E =new Entraineur("ahmed","ahmed", "ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed", 2,"2022-02-28",2);
        UtilisateurService us =new UtilisateurService();
        us.ajouterUtilisateur(A);
        us.ajouterUtilisateur(E);
        us.ajouterUtilisateur(U);
        //us.SupprimerParidentificateur("wejdi","wejdi");
        System.out.println(us.afficherUtilisateur());
    }
    
}
