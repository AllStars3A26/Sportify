/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Adherant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tools.MaConnexion;

/**
 *
 * @author Fayechi
 */
public class AdherantService {
    Connection cnx;

    public AdherantService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    
     public  int rechercheparlogin(String login){
         int nbrRow=0;
        try{
          String sql="SELECT * FROM user WHERE login_user='"+login+"'"; 
          PreparedStatement ste = cnx.prepareStatement(sql);
           ResultSet rst= ste.executeQuery(sql);
           //pointeur sur la dernier row du result set 
           rst.last();
            nbrRow = rst.getRow();
           if(nbrRow!=0){
               //System.out.println("Entreineur trouve donc cours trouve");
            return nbrRow;
           }else{
               // System.out.println("Entreineur non trouve donc cours non trouve");
            return nbrRow;
           }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
       
            return nbrRow;
    }
    public void ajouterAdherant(Adherant A){
         if (rechercheparlogin(A.getLogin_user())!=0) {
                System.out.println("Adhérant existant ");
            }
         else{
        String sql="INSERT INTO `user`( `date_inscritA`,`nom_user`, `prenom_user`, `adresse_user`, `login_user`, `password_user`, `role`) VALUES ('"+A.getDate_inscrit()+"','"+A.getNom_user()+"','"+A.getPrenom_user()+"','"+A.getAdresse_user()+"','"+A.getLogin_user()+"','"+A.getPassword_user()+"','0')";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            
            System.out.println("Adhérant ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         }
        
    }
  /*  public void ajouterAdherant2(Adherant A){
        String sql="insert into user(nom_user,prenom_user,adresse_user,login_user,password_user,role,date_inscritA) values(?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
            
            
            ste.setString(1, A.getNom_user());
            ste.setString(2, A.getPrenom_user());
            ste.setString(3, A.getAdresse_user());
            ste.setString(4, A.getLogin_user());
            ste.setString(5, A.getPassword_user());
            ste.setInt(6, A.getRole());
            ste.setString(7, A.getDate_inscrit());
            ste.executeUpdate();
            System.out.println("Adhérant Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
       public  void ModifierA( String login, String nom_user, String prenom_user,String adresse_user,String login_user,String password_user ){
       try{
           String sql="UPDATE User  SET nom_user='"+nom_user
                   +"', prenom_user="+prenom_user
                   +", adresse_user="+adresse_user
                   +", login_user="+login_user
                   +", password_user="+password_user
                   +" WHERE Where role=0 AND login_user='"+login+"'";
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Adhérant modifié");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       
       
   }
    
    public List<Adherant> afficherAdherant(){
        List<Adherant> Adherants = new ArrayList<>();
        String query="select * from User where role=0";
        
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                Adherant p = new Adherant();
                p.setId_user(rs.getInt("id_user"));
                p.setNom_user(rs.getString("nom_user"));
                p.setPrenom_user(rs.getString("prenom_user"));
                p.setAdresse_user(rs.getString("Adresse_user"));
                p.setLogin_user(rs.getString("Login_user"));
                p.setDate_inscrit(rs.getString("date_inscritA"));
                
                Adherants.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Adherants;
        
    }
public  void SupprimerParlogin(String login){
        try{
           String sql="DELETE * FROM user WHERE login_user='"+login+"' and role=0"; 
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Adhérant supprimé");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
  
    
}
