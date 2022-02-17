/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Seance;
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
 * @author Lenovo
 */
public class SeanceService {
     Connection cnx;

    public SeanceService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
        public void ajouterSeance(Seance C){
            String dtFormat = "dd/MM/yyyy";
            String hrFormat = "HH:mm";
            if ((rechercheCparheure(C.getHeure_debut(),C.getNom_T(),C.getDate())!=0) )
            {
               
                System.out.println("terrein deja reserver a cette heure a cette date ");
            }
            else if (DatecheckerService.isValid(C.getDate(), dtFormat)==false){
                System.out.println("date incorrecte saisie une date sous la forme dd/MM/yyyy");
            }
             else if (HeurecheckerService.isValid(C.getHeure_debut(), hrFormat)==false){
                System.out.println("date incorrecte saisie une date sous la forme HH:mm");
            }
            else{
            String sql="INSERT INTO `Seance`(`id`, `date`, `hrd`, `nomt`, `nome`) VALUES ('"+C.getId()+"','"+C.getDate()+"','"+C.getHeure_debut()+"','"+C.getNom_T()+"','"+C.getNom_E()+"')";
            try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Seance Ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}
        
        
    }
    
    public List<Seance> afficherSeance(){
        List<Seance> li = new ArrayList<>();
        String query="select * from Seance";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                Seance c = new Seance();
                c.setId(rs.getInt("id"));
                c.setDate(rs.getString("date"));
                c.setHeure_debut(rs.getString("hrd"));
                c.setNom_T(rs.getString("nomt"));
                c.setNom_E(rs.getString("nome"));
                li.add(c);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return li;
        
    }
    // supprimer seance par son entreineur
     public  void SupprimerParnom(String nome,String date){
            String dtFormat = "dd/MM/yyyy";

          if (DatecheckerService.isValid(date, dtFormat)==false){
                System.out.println("date incorrecte saisie une date sous la forme dd/MM/yyyy");
            }
          else{
        try{
           String sql="DELETE FROM Seance WHERE nome='"+nome+"' AND date='"+date+"'" ; 
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("SEANCE bien supprimé");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
          }
    }
     //rechercher une seance par nom d'entreineur 
     public  int rechercheCparheure(String hrd,String nomt, String date){
         int nbrRow=0;
        try{
          String sql="SELECT * FROM Seance WHERE hrd='"+hrd+"' AND nomt='"+nomt+"' AND DATE='"+date+"'"; 
          PreparedStatement ste = cnx.prepareStatement(sql);
           ResultSet rst= ste.executeQuery(sql);
           //pointeur sur la dernier row du result set 
           rst.last();
            nbrRow = rst.getRow();
           if(nbrRow!=0){
              // System.out.println("Entreineur trouve donc SEANCE trouve");
            return nbrRow;
           }else{
                //System.out.println("Entreineur non trouve donc SEANCE non trouve");
            return nbrRow;
           }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
       
            return nbrRow;
    }
     // fonction modifier base entreineur
      public  void ModifierC( String date, String heure_debut, String nom_T,String nom_E ){
            String dtFormat = "dd/MM/yyyy";
            String hrFormat = "HH:mm";
          if (DatecheckerService.isValid(date, dtFormat)==false){
                System.out.println("date incorrecte saisie une date sous la forme dd/MM/yyyy");
            }
             else if (HeurecheckerService.isValid(heure_debut, hrFormat)==false){
                System.out.println("date incorrecte saisie une date sous la forme HH:mm");
            }
             else{
       try{
           String sql="UPDATE seance SET date='"+date+"',hrd='"+heure_debut+"',nomt='"+nom_T+"' WHERE nome='"+nom_E+"'";
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Seance bien modifié");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       
             }
   }
     
     public int CountSeance() throws SQLException
    {
        
       
               int total = 0;
            String sql="Select count(*) from Seance";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ResultSet rst = ste.executeQuery(sql);
            
             while (rst.next())
            {
               total  = rst.getInt("count(*)");
            }
            
            return total;
    }
    
}
