/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;

/**
 *
 * @author snowy
 */
public class Produitservices {
    Connection cnx;
    public Produitservices() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    public void ajouterProduit(Produit c){
        
        String sql="INSERT INTO `produit`(`id_prod`, `nom_prod`, `prix_prod`,`cat_prod` ,`desc_prod`) VALUES ('"+c.getId_prod()+"','"+c.getNom_prod()+"','"+c.getPrix_prod()+"','"+c.getCat_prod()+"','"+c.getDesc_prod()+"')";
     
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Produit Ajoutee");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
    
public void modifierProduit(Produit p,int id, String nom_prod,float prix_prod,String cat_prod,String desc_prod) {
String sql="UPDATE `produit` SET `nom_prod` = '" + nom_prod + "', `prix_prod` = '" + prix_prod+ "', `cat_prod` = '" + cat_prod+ "',`desc_prod` = '" + desc_prod+ "' WHERE `produit`.`id_prod` = '"+id+"'";        
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Produit Modifieé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
     public List<Produit> afficherProduit(){
        List<Produit> produits = new ArrayList<>();
        String query="select * from produit";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
               Produit p = new Produit();
                p.setId_prod(rs.getInt("id_prod"));
                p.setNom_prod(rs.getString("nom_prod"));
                p.setPrix_prod(rs.getFloat("prix_prod"));
                p.setCat_prod(rs.getString("cat_prod"));
                p.setDesc_prod(rs.getString("Desc_prod"));

               
               produits.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return produits;
        
    }
    
    
    
    public void supprimerProduit(int id) {
 try {
            String sql = "DELETE FROM produit WHERE id_prod="+id+"";
            PreparedStatement ste  = cnx.prepareStatement(sql);
           
            ste.executeUpdate();
            System.out.println("produit supprimée ");
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
}
