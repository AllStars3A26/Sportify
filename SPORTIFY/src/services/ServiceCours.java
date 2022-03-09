/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MYDB;
import java.util.Collections;
/**
 *
 * @author Sahar Zouari
 */
public class ServiceCours implements IService<Cours> {
    
    private Connection cnx;

    public ServiceCours() {
        cnx = MYDB.getInstance().getConnection();
    }

      public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_cours FROM cours";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_cours"));}
            Collections.sort(st);
            for(int i=0;i<st.size() && test==false;i++)
            {int b= (int)st.get(i);
               if(j<b)
                    test= true;
                else
                  j++;
            };
         } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return j;
    }
    
    @Override
    public void ajouter(Cours t) {
                String sql="INSERT INTO cours (id_cours, titre, nome, type, imc,nb_heure) VALUES (?,?,?,?,?,?)";
        try {
            int nextId = id_auto();
            PreparedStatement ste= cnx.prepareStatement(sql);
            
            ste.setInt(1,nextId);
            ste.setString(2, t.gettitre());
            ste.setString(3, t.getNomE());
            ste.setString(4,t.getType());
            ste.setString(5, t.getImc());
            ste.setInt(6, t.getNb_heure());
            ste.executeUpdate();
            System.out.println("Cours Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}

 

     @Override
    public void modifier(Cours t) {
       try{
            String req = "UPDATE cours SET titre = ?, nome = ?, type= ?, imc= ? ,nb_heure=? WHERE id_cours= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        
        ps.setString(1,t.gettitre());
        ps.setString(2,t.getNomE());
        ps.setString(3,t.getType());
        ps.setString(4,t.getImc());
        ps.setInt(5,t.getNb_heure());
     
         System.out.println("Modification...");
         ps.executeUpdate();
      
        System.out.println("Une ligne modifiée dans la table...");
       }
       catch(SQLException e){
           
       }}
    
  @Override
    public void supprimer(int id) {
       try{
            String req = "DELETE FROM cours WHERE id_cours = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
    
       @Override
    public List<Cours> afficher() {
        List <Cours> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM cours";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                Cours c = new Cours();
                c.settitre(rs.getString("titre"));
                c.setNomE(rs.getString("nome"));
                 c.setType(rs.getString("type")); 
                  c.setImc(rs.getString("imc"));
               c.setNb_heure(rs.getInt("nb_heure"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
     public List<Cours> afficherId(int id) {
        List <Cours> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM cours where id_cours="+id;
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                Cours c = new Cours();
                c.setId_cours(rs.getInt("id_cours"));
                c.settitre(rs.getString("titre"));
                 c.setNomE(rs.getString("nom_E")); 
                  c.setType(rs.getString("type"));
               c.setImc(rs.getString("imc"));
               c.setNb_heure(rs.getInt("nb_heure"));
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
}
    
