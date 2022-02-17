/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Entraineur;

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
public class EntraineurService {
    Connection cnx;

    public EntraineurService() {
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
    public void ajouterEntraineur(Entraineur A){
          if (rechercheparlogin(A.getLogin_user())!=0) {
                System.out.println("Adhérant existant ");
            }
         else{
        String sql="INSERT INTO `user`(`id_user`, `nom_user`, `prenom_user`, `adresse_user`, `login_user`, `password_user`, `role`,`type_contratE`, `duree_contratE`, `dated_contratE`) VALUES ('"+A.getId_user()+"','"+A.getNom_user()+"','"+A.getPrenom_user()+"','"+A.getAdresse_user()+"','"+A.getLogin_user()+"','"+A.getPassword_user()+"','1','"+A.getType_contrat()+"','"+A.getDuree_contrat()+"','"+A.getDated_contrat()+"')";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            
            System.out.println("Entraineur Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
          }
    }
    
    
    
         public  void ModifierE( String login, String nom_user, String prenom_user,String adresse_user,String login_user,String password_user,String type_contrat,int duree_contrat ){
       try{
           String sql="UPDATE User  SET nom_user='"+nom_user
                   +"', prenom_user="+prenom_user
                   +", adresse_user="+adresse_user
                   +", login_user="+login_user
                   +", password_user="+password_user
                   +", type_contratE="+type_contrat
                   +", duree_contratE="+duree_contrat
                   +" WHERE Where role=0 AND login_user='"+login+"'";
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Adhérant modifié");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       
       
   }
         public  void SupprimerParloginE(String login){
        try{
           String sql="DELETE * FROM user WHERE login_user='"+login+"' and role=1"; 
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Entraineur supprimé");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
  
         /*public void ajouterEntraineur2(Entraineur A){
        String sql="insert into user(id_user,nom_user,prenom_user,adresse_user,login_user,password_user,role,type_contratE, duree_contratE, dated_contratE) values(?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
            
            ste.setInt(1, A.getId_user());
            ste.setString(2, A.getNom_user());
            ste.setString(3, A.getPrenom_user());
            ste.setString(4, A.getAdresse_user());
            ste.setString(5, A.getLogin_user());
            ste.setString(6, A.getPassword_user());
            ste.setInt(7, A.getRole());
            ste.setString(8, A.getType_contrat());
            ste.setInt(9, A.getDuree_contrat());
            ste.setString(10, A.getDated_contrat());
            ste.executeUpdate();
            System.out.println("Entraineur Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    
    public List<Entraineur> afficherEntraineur(){
        List<Entraineur> Entraineurs = new ArrayList<>();
        String query="select * from User where role=1";
        
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                Entraineur p = new Entraineur();
                p.setId_user(rs.getInt("id_user"));
                p.setNom_user(rs.getString("nom_user"));
                p.setPrenom_user(rs.getString("prenom_user"));
                p.setAdresse_user(rs.getString("Adresse_user"));
                p.setLogin_user(rs.getString("Login_user"));
                p.setType_contrat(rs.getString("type_contratE"));
                p.setDuree_contrat(rs.getInt("duree_contratE"));
                p.setDated_contrat(rs.getString("dated_contratE"));
                Entraineurs.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Entraineurs;
        
    }

  
    
}
