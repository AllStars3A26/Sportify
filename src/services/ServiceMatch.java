/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.match;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MYDB;
/**
 *
 * @author Sahar Zouari
 */
public class ServiceMatch implements IService<match> {
    
    private Connection cnx;

    public ServiceMatch() {
        cnx = MYDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(match t) {
                String sql="insert into sportify.match(id_match,id_equipe1,id_equipe2,date_match,resultat_match) values(?,?,?,?,?)";
        try {
           
            PreparedStatement ste= cnx.prepareStatement(sql);
            ste.setInt(1, t.getId_match());
            ste.setInt(2, t.getId_equipe1());
            ste.setInt(3, t.getId_equipe2());
            ste.setString(4, t.getDate_match());
            ste.setInt(5, t.getResultat_match());
            ste.executeUpdate();
            System.out.println("Match Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}

 

    @Override
    public void modifier(match t) {
   try{
            String req = "UPDATE sportify.match SET id_equipe1 = ?, id_equipe2 = ?, date_match= ?, resultat_match= ? WHERE id_match= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
       
        ps.setInt(1,t.getId_equipe1());
        ps.setInt(2,t.getId_equipe2());
        ps.setString(3,t.getDate_match());
        ps.setInt(4,t.getResultat_match());
        ps.setInt(5,t.getId_match());
         System.out.println("Modification...");
         ps.executeUpdate();
      
        System.out.println("Une ligne modifiée dans la table...");
       }
       catch(SQLException e){
           
       }}

    @Override
    public void supprimer(int id) {
       try{
            String req = "DELETE FROM sportify.match WHERE id_match = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
       @Override
    public List<match> afficher() {
             List<match> list = new ArrayList<>();
        try{
            String req = "SELECT * FROM sportify.match";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                match m = new match();
              m.setId_match(rs.getInt(1));
              m.setId_equipe1(rs.getInt(2));
              m.setId_equipe2(rs.getInt(3));
              m.setDate_match(rs.getString(4));
              m.setResultat_match(rs.getInt(5));
              
                
                list.add(m);
            }
    }

  
        catch(SQLException m){
            
        }
        return list ;   }
    
}
    
