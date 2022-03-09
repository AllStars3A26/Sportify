/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Seance;
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
import java.util.Comparator;
/**
 *
 * @author Sahar Zouari
 */
public class ServiceSeance implements IService<Seance> {

    
    private Connection cnx;

    public ServiceSeance() {
        cnx = MYDB.getInstance().getConnection();
    }
    
      public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_seance FROM seance";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_seance"));}
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
    public void ajouter(Seance t) {
       
        String sql="INSERT INTO seance(id_seance, date_seance, heure_seance, nom_T, nom_E,nb_participants) VALUES (?,?,?,?,?,?)";
        try {
             int nextId = id_auto();
            PreparedStatement ste= cnx.prepareStatement(sql);
             java.sql.Date d = new java.sql.Date(t.getDate_seance().getTime());
            ste.setInt(1, nextId);
            ste.setDate(2, d);
            ste.setInt(3, t.getHeure_debut());
            
            ste.setString(4, t.getNom_T());
            ste.setString(5, t.getNom_E());
            ste.setInt(5, 0);
            ste.executeUpdate();
            System.out.println("Seance Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
        
        
    }



      
     @Override
    public void modifier(Seance t) {
       try{
            String req = "UPDATE seance SET date_seance = ?, heure_seance = ?, nom_T= ?, nom_E= ?  WHERE id_cours= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        java.sql.Date d = new java.sql.Date(t.getDate_seance().getTime());
        ps.setDate(1,d);
        ps.setInt(2,t.getHeure_debut());
        ps.setString(3,t.getNom_T());
        ps.setString(4,t.getNom_E());
        
     
         System.out.println("Modification...");
         ps.executeUpdate();
      
        System.out.println("Une ligne modifiée dans la table...");
       }
       catch(SQLException e){
           
       }}
    

    @Override
    
    public void supprimer(int id) {
       try{
            String req = "DELETE FROM seance WHERE id_seance = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
           @Override
   public List<Seance> afficher() {
        List <Seance> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM seance";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                Seance c = new Seance();
                c.setId_seance(rs.getInt("id_seance"));
                c.setDate_seance(rs.getDate("date_seance"));
                 c.setHeure_debut(rs.getInt("heure_seance")); 
                  c.setNom_T(rs.getString("nom_T"));
               c.setNom_E(rs.getString("nom_E"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
   public List<Seance> afficherId(int id) {
        List <Seance> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM seance where id_seance="+id;
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                Seance c = new Seance();
                c.setId_seance(rs.getInt("id_seance"));
                c.setDate_seance(rs.getDate("date_seance"));
                 c.setHeure_debut(rs.getInt("heure_seance")); 
                  c.setNom_T(rs.getString("nom_T"));
               c.setNom_E(rs.getString("nom_E"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
      public int nb_seance(List<Seance> l)
   {
       return l.size();
   }
      public void participer(Seance l) {
      try{      
      String request3="UPDATE `seance` SET `nb_participants`=`nb_participants` +1 where `id_seance`='"+l.getId_seance()+"'";
         
 Statement st=new MYDB().getConnection().createStatement();
       st.executeUpdate(request3);
        System.out.println("participation faite avec succes");
   
     }
     catch(SQLException ex){
     }}
    
        
          

//UPDATE `DropletNames` SET `Monday` = `Monday` + 1 WHERE `Title = "Travel to Mars"
              
              
              
              
  
      
      public  List<Seance> TrierParnom(){
         Comparator<Seance> comparator =
  Comparator.comparing(Seance::getNom_T);
          List<Seance> li = new ArrayList<>();
        String query="select * from seance";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                Seance c = new Seance();
               c.setId_seance(rs.getInt("id_seance"));
                c.setDate_seance(rs.getDate("date_seance"));
                 c.setHeure_debut(rs.getInt("heure_seance")); 
                  c.setNom_T(rs.getString("nom_T"));
               c.setNom_E(rs.getString("nom_E"));
                li.add(c);
                li.stream().sorted(comparator);
  //.forEach(a ->
   // System.out.printlnW(a.getHeure_debut() + " " + a.getDate() + " " + a.getNom_T()+ " " + a.getNom_E()));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return li;
     }
}

