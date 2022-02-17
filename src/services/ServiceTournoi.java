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

/**
 *
 * @author Sahar Zouari
 */
public class ServiceTournoi implements IService<tournoi> {

    
    private Connection cnx;

    public ServiceTournoi() {
        cnx = MYDB.getInstance().getConnection();
    }
    
    
    @Override
    public void ajouter(tournoi t) {
       
        String sql="insert into tournoi(id_tournoi,nom_tournoi,date_tournoi,resultat_tournoi,nb_participants,image_tournoi) values(?,?,?,?,?,?)";
        try {
           
            PreparedStatement ste= cnx.prepareStatement(sql);
            ste.setInt(1, t.getId_tournoi());
            ste.setString(2, t.getNom_tournoi());
            ste.setString(3, t.getDate_tournoi());
            ste.setInt(4, t.getResultat_tournoi());
            ste.setInt(5, t.getNb_participants());
            ste.setString(6, t.getImage_tournoi());
            ste.executeUpdate();
            System.out.println("Tournoi Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
        
        
    }



    @Override
    public void modifier(tournoi t) {
       try{
            String req = "UPDATE tournoi SET nom_tournoi = ?, date_tournoi = ?, resultat_tournoi= ?, nb_participants= ?, image_tournoi= ? WHERE id_tournoi= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
       
        ps.setString(1,t.getNom_tournoi());
        ps.setString(2,t.getDate_tournoi());
        ps.setInt(3,t.getResultat_tournoi());
        ps.setInt(4,t.getNb_participants());
        ps.setString(5,t.getImage_tournoi());
        ps.setInt(6,t.getId_tournoi());
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
         List<tournoi> list = new ArrayList<>();
        try{
            String req = "SELECT * FROM tournoi";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                tournoi t = new tournoi();
              t.setId_tournoi(rs.getInt(1));
              t.setNom_tournoi(rs.getString(2));
              t.setDate_tournoi(rs.getString(3));
              t.setResultat_tournoi(rs.getInt(4));
              t.setNb_participants(rs.getInt(5));
              t.setImage_tournoi(rs.getString(6));
                
                list.add(t);
            }
    }

  
        catch(SQLException t){
            
        }
        return list ;   }
    
}
