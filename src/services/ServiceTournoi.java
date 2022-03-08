/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.tournoi;
import java.util.List;
import util.MYDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Sahar Zouari
 */
public class ServiceTournoi implements IService<tournoi> {

    
    private Connection cnx;

    public ServiceTournoi() {
        cnx = MYDB.getInstance().getConnection();
    }
    
      public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_tournoi FROM SPORTIFY.tournoi";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_tournoi"));}
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
    public void ajouter(tournoi t) {
       
        String sql="insert into tournoi(id_tournoi,nom_tournoi,date_tournoi,resultat_tournoi,nb_participants,image_tournoi,heure) values(?,?,?,?,?,?,?)";
        try {
             int nextId = id_auto();
            PreparedStatement ste= cnx.prepareStatement(sql);
             java.sql.Date d = new java.sql.Date(t.getDate_tournoi().getTime());
            ste.setInt(1, nextId);
            ste.setString(2, t.getNom_tournoi());
            ste.setDate(3, d);
            ste.setInt(4, t.getResultat_tournoi());
            ste.setInt(5, t.getNb_participants());
            ste.setString(6, t.getImage_tournoi());
            ste.setInt(7,t.getHeure());
            ste.executeUpdate();
            System.out.println("Tournoi Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
        
        
    }



    @Override
    public void modifier(tournoi t) {
       try{
            String req = "UPDATE tournoi SET nom_tournoi = ?, date_tournoi = ?, resultat_tournoi= ?, nb_participants= ?, image_tournoi= ? ,heure=? WHERE id_tournoi= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        java.sql.Date d = new java.sql.Date(t.getDate_tournoi().getTime());
        ps.setString(1,t.getNom_tournoi());
        ps.setDate(2,d);
        ps.setInt(3,t.getResultat_tournoi());
        ps.setInt(4,t.getNb_participants());
        ps.setString(5,t.getImage_tournoi());
        ps.setInt(6,t.getHeure());
        ps.setInt(7,t.getId_tournoi());
         System.out.println("Modification...");
         ps.executeUpdate();
      
        System.out.println("Une ligne modifiée dans la table...");
       }
       catch(SQLException e){
           
       }}

    @Override
    public void supprimer(int id) {
       try{
            String req = "DELETE FROM tournoi WHERE id_tournoi = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
           @Override
   public List<tournoi> afficher() {
        List <tournoi> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM tournoi";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                tournoi c = new tournoi();
                c.setId_tournoi(rs.getInt("id_tournoi"));
                c.setNom_tournoi(rs.getString("nom_tournoi"));
                 c.setDate_tournoi(rs.getDate("date_tournoi")); 
                  c.setResultat_tournoi(rs.getInt("resultat_tournoi"));
                  c.setHeure(rs.getInt("heure"));
                c.setNb_participants(rs.getInt("nb_participants"));
                c.setImage_tournoi(rs.getString("image_tournoi"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
   public List<tournoi> afficherId(int id) {
        List <tournoi> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM tournoi where id_tournoi="+id;
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                tournoi c = new tournoi();
                c.setId_tournoi(rs.getInt("id_tournoi"));
                c.setNom_tournoi(rs.getString("nom_tournoi"));
                 c.setDate_tournoi(rs.getDate("date_tournoi")); 
                  c.setResultat_tournoi(rs.getInt("resultat_tournoi"));
                  c.setHeure(rs.getInt("heure"));
                c.setNb_participants(rs.getInt("nb_participants"));
                c.setImage_tournoi(rs.getString("image_tournoi"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
      public int nb_tournoi(List<tournoi> l)
   {
       return l.size();
   }
}