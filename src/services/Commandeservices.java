/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commande;
import java.sql.Connection;
import java.sql.Date;
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
public class Commandeservices {
    Connection cnx;
    public Commandeservices() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    public void ajouterCommande(Commande c){
        String dtFormat = "dd/MM/yyyy";
        String sql="INSERT INTO `commande`(`id_com`, `date_com`, `prix_com` ,`quant_com`) VALUES ('"+c.getId_com()+"','"+c.getDate_com()+"','"+c.getPrix_com()+"','"+c.getQuant_com()+"')";
        if (DatecheckerService.isValid(c.getDate_com(), dtFormat)==false){
                System.out.println("date incorrecte saisie une date sous la forme dd/MM/yyyy");
            }
        else{
            
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Commande Ajoutee");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }}
    }
    
public void modifierCommande(Commande c,int id, String date_com,float prix_com,int quant_com) {
String sql="UPDATE `commande` SET `date_com` = '" + date_com + "', `prix_com` = '" + prix_com+ "', `quant_com` = '" + quant_com+ "' WHERE `commande`.`id_com` = '"+id+"'";        
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Commande Modifieé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
     public List<Commande> afficherCommande(){
        List<Commande> commandes = new ArrayList<>();
        String query="select * from commande";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
               Commande c = new Commande();
                c.setId_com(rs.getInt("id_com"));
                c.setDate_com(rs.getString("date_com"));
                c.setPrix_com(rs.getFloat("prix_com"));
                c.setQuant_com(rs.getInt("quant_com"));
               
               commandes.add(c);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return commandes;
        
    }
    
    
    
    public void supprimerCommande(int id) {
 try {
            String sql = "DELETE FROM commande WHERE id_com="+id+"";
            PreparedStatement ste  = cnx.prepareStatement(sql);
           
            ste.executeUpdate();
            System.out.println("commande supprimée ");
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
}
