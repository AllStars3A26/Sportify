/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Personne;
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
 * @author Fayechi
 */
public class PersonneService {
    Connection cnx;

    public PersonneService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    public void ajouterPersonne(Personne p){
        String sql="INSERT INTO `Personne`(`id`, `nom`, `prenom`) VALUES ('"+p.getId()+"','"+p.getNom()+"','"+p.getPrenom()+"')";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Personne Ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    public void ajouterPersonne2(Personne p){
        String sql="insert into personne(nom,prenom) values(?,?)";
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
            ste.executeUpdate();
            System.out.println("Personne Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Personne> afficherPersonne(){
        List<Personne> personnes = new ArrayList<>();
        String query="select * from personne";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                Personne p = new Personne();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                personnes.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return personnes;
        
    }
    
}
