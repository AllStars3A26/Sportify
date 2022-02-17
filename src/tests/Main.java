/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
        import tools.MaConnexion;
import entities.Commande;
import entities.Produit;
import services.*;


/**
 *
 * @author snowy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MaConnexion mc = MaConnexion.getInstance();
        Commande c1 = new Commande(0, "13/12/2000", 0, 0);
        Produit p1 = new Produit(0,"Maillot",13.5f,"Vetements","azertyuihjiazbfgfuazefn");
     
        Commandeservices cs = new Commandeservices();
        Produitservices ps = new Produitservices();

        //cs.ajouterCommande(c1);
        //cs.modifierCommande(c1, 2, "",12 , );
        //ps.ajouterProduit(p1);
      //ps.modifierProduit(p1, 3, "", 0, "", "");
           //System.out.println(ps.afficherProduit());
        //System.out.println(cs.afficherCommande());
        //cs.supprimerCommande(4);
        ps.supprimerProduit(2);
                
    }
    
}
