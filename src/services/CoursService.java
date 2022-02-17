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
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;
/**
 *
 * @author Lenovo
 */
public class CoursService {
         Connection cnx;

    public CoursService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
        public void ajouterCour(Cours C){
            if (rechercheCpartitre(C.gettitre())!=0) {
                System.out.println("Cour deja ajoutee ");
            }
            else {
            String sql="INSERT INTO `Cours`(`id`, `titre`, `nome`, `type`, `imc`) VALUES ('"+C.getId()+"','"+C.gettitre()+"','"+C.getNomE()+"','"+C.getType()+"','"+C.getImc()+"')";
            try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Cour Ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
        
    }
    public void ajouterCour2(Cours p){
        String sql="insert into Cours(titre,nome,type,imc) values(?,?)";
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
            ste.setString(1, p.gettitre());
            ste.setString(2, p.getNomE());
            ste.setString(3, p.getType());
            ste.setString(4, p.getImc());
            ste.executeUpdate();
            System.out.println("Cour Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
}
    
    public List<Cours> afficherCours(){
        List<Cours> cour = new ArrayList<>();
        String query="select * from Cours";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                Cours c = new Cours();
                c.setId(rs.getInt("id"));
                c.settitre(rs.getString("titre"));
                c.setNomE(rs.getString("nome"));
                c.setType(rs.getString("type"));
                c.setImc(rs.getString("imc"));
                cour.add(c);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return cour;
        
    }
    // supprimer un cours par son titre
     public  void SupprimerPartitre(String titre_cour){
        try{
           String sql="DELETE FROM cours WHERE titre='"+titre_cour+"'"; 
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("cour bien supprimé");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
     //rechercher un cour par nom d'entreineur 
     public  int rechercheCpartitre(String titre){
         int nbrRow=0;
        try{
          String sql="SELECT * FROM cours WHERE titre='"+titre+"'"; 
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
     // fonction modifier base a titre
      public  void ModifierC(String titre,String nom_e,String type,String imc ){
       try{
           String sql="UPDATE Cours SET nome='"+nom_e+"', type='"+type+"',imc='"+imc+"' WHERE titre='"+titre+"'";
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Cours bien modifié");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       
       
   }
     
    
    
    
}
