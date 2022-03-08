/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.ParticipantsTournoi;
import entities.tournoi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.MYDB;

/**
 *
 * @author Sahar Zouari
 */
public class ServiceParticipant {
           private Connection cnx;  
    public ServiceParticipant() {
        cnx = MYDB.getInstance().getConnection();
    }
   public List<ParticipantsTournoi> afficher() {
        List <ParticipantsTournoi> st = new ArrayList<>();
        try {
            String requete = "select p.*,t.nom_tournoi,e.nom_equipe from participants_tournoi p,tournoi t,equipe e where(p.id_tournoi=t.id_tournoi) AND (p.id_equipe=e.id_equipe)";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                ParticipantsTournoi c = new ParticipantsTournoi();
                c.setId_tournoi(rs.getInt("id_tournoi"));
                c.setNom_tournoi(rs.getString("nom_tournoi"));
                c.setNom_equipe(rs.getString("nom_equipe")); 
                c.setId_participants(rs.getInt("id_participants"));
                c.setId_equipe(rs.getInt("id_equipe"));
                
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
   }
  public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_participant FROM participants_tournoi";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_participant"));}
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
    
    
//    public List<tournoi>chercher_tournoi(String recherche) {
//        
//        
//        
//        String requete="select * from abonnement where id_abonnement=?";
//        ResultSet rs=null;
//        List list=new ArrayList();
//        try{
//            PreparedStatement ps=cnx.prepareStatement(requete);
//            ps.setInt(1, id_abonnement);
//            
//            rs=ps.executeQuery();
//        }catch(SQLException ex){
//            System.err.println(ex.getMessage());
//        }
//        Abonnement a=new Abonnement();
//        try{
//            while(rs.next()){
//                a.setId_abonnement(rs.getInt("id_abonnement"));
//                a.setDate_debut(rs.getString("date_debut"));
//                a.setDate_fin(rs.getString("date_fin"));
//                a.setType(rs.getString("type"));
//                list.add(new Abonnement(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4)));
//            }
//        }catch(SQLException exc){
//             System.err.println(exc.getMessage());
//        }
//        return list;
//    }
    
    
    
    
    public void ajouter(ParticipantsTournoi t) {
      List<ParticipantsTournoi> p = afficher();
      boolean test =true;
        for (int i = 0; i < p.size(); i++) {
           if (p.get(i).getId_equipe()==t.getId_equipe())
           {
               test=false;
           }
        }
        if(test==true)
        {try {
           
            int nextId = id_auto();
            String requete = "INSERT INTO participants_tournoi (id_participant,id_tournoi,id_equipe) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,nextId);
            pst.setInt(2,t.getId_tournoi());
            pst.setInt(3,t.getId_equipe());
         
           
            pst.executeUpdate();
            System.out.println("Participant ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }}
        else
        {System.out.println("vous êtes deja inscrit!");}
    }

}

