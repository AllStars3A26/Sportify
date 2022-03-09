/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.terrain;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
/**
 *
 * @author ASUS
 */
public class Serviceterrain implements IService<terrain> {

    
    private Connection cnx;

    public Serviceterrain() {
        cnx = MYDB.getInstance().getConnection();
    }
    
      public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_terrain FROM terrain";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_terrain"));}
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
    public void ajouter(terrain t) {
       
        String sql="insert into terrain(id_terrain,nom_terrain,type_terrain,description_terrain,adresse_terrain,disponibilite) values(?,?,?,?,?,?)";
        try {
             int nextId = id_auto();
            PreparedStatement ste= cnx.prepareStatement(sql);
            
            ste.setInt(1, nextId);
            ste.setString(2, t.getNom_terrain());
            ste.setString(3, t.getType_terrain());
            ste.setString(4, t.getDescription_terrain());
            ste.setString(5, t.getAdresse_terrain());
            ste.setString(6, t.getDisponibilite());
            ste.executeUpdate();
            System.out.println("Terrain Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
        
        
    }



    @Override
    public void modifier(terrain t) {
       try{
           String sql="UPDATE Terrain SET type_terrain='"+t.getType_terrain()+"',description_terrain='"+t.getDescription_terrain()+"',adresse_terrain='"+t.getAdresse_terrain()+"',disponibilite='"+t.getDisponibilite()+"' WHERE nom_terrain='"+t.getNom_terrain()+"'";
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Terrain bien modifié");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }}

    @Override
    public void supprimer(int id) {
       try{
            String req = "DELETE FROM terrain WHERE id_terrain = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
           @Override
   public List<terrain> afficher() {
        List <terrain> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM terrain";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                terrain c = new terrain();
                c.setId_terrain(rs.getInt("id_terrain"));
                c.setNom_terrain(rs.getString("nom_terrain"));
                 c.setType_terrain(rs.getString("type_terrain"));
                  c.setDescription_terrain(rs.getString("description_terrain"));
                  c.setAdresse_terrain(rs.getString("adresse_terrain"));
                  c.setDisponibilite(rs.getString("disponibilite"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
   public List<terrain> afficherId(int id) {
        List <terrain> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM terrain where id_terrain="+id;
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                terrain c = new terrain();
                c.setId_terrain(rs.getInt("id_terrain"));
                c.setNom_terrain(rs.getString("nom_terrain"));
                 c.setType_terrain(rs.getString("type_terrain")); 
                  c.setDescription_terrain(rs.getString("description_terrain"));
                  c.setAdresse_terrain(rs.getString("adresse_terrain"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
   
   public List<terrain> afficherDispo() {
        List <terrain> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM terrain where disponibilite= 'oui'" ;
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                terrain c = new terrain();
                c.setId_terrain(rs.getInt("id_terrain"));
                c.setNom_terrain(rs.getString("nom_terrain"));
                 c.setType_terrain(rs.getString("type_terrain")); 
                  c.setDescription_terrain(rs.getString("description_terrain"));
                  c.setAdresse_terrain(rs.getString("adresse_terrain"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
      public int nb_terrain(List<terrain> l)
   {
       return l.size();
   }
      
      public List<terrain> rechercheterrain(Object a){
          List <terrain> st = new ArrayList<>();
        String query = null;
        if(a instanceof String){
        query = "select * from terrain where nom_terrain LIKE '"+a+"%' OR nom_terrain LIKE '%"+a+"' OR nom_terrain LIKE '%"+a+"%' OR type_terrain LIKE '"+a+"%' OR type_terrain LIKE '%"+a+"' OR type_terrain LIKE '%"+a+"%' OR description_terrain LIKE '"+a+"%' OR description_terrain LIKE '%"+a+"' OR description_terrain LIKE '%"+a+"%' OR adresse_terrain LIKE '"+a+"%' OR adresse_terrain LIKE '%"+a+"' OR disponibilite LIKE '%"+a+"%'  OR adresse_terrain LIKE '"+a+"%' OR disponibilite LIKE '%"+a+"' OR disponibilite LIKE '%"+a+"%'   ";
     }else if(a instanceof Integer){
        query="select * from terrain where id_terrain>="+a+"";
     }
        try {
            PreparedStatement ste;
            ste = cnx.prepareStatement(query);
            ResultSet rs;
            rs = ste.executeQuery();
            //rs.next();
            while(rs.next()){
                terrain h = new terrain();
                
                h.setId_terrain(rs.getInt("id_terrain"));
                h.setNom_terrain(rs.getString("nom_terrain"));
                h.setType_terrain(rs.getString("type_terrain"));
                h.setDescription_terrain(rs.getString("description_terrain"));
                h.setAdresse_terrain(rs.getString("adresse_terrain"));
                h.setDisponibilite(rs.getString("disponibilite"));
                
                
                st.add(h);
                
                //rs.next();
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return st;
        

        
       
    }
      
      
      
      
      public  List<terrain> TrierParnom(){
         Comparator<terrain> comparator =
  Comparator.comparing(terrain::getNom_terrain).thenComparing(terrain::getType_terrain).reversed();
          List<terrain> li = new ArrayList<>();
        String query="select * from terrain";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                terrain h = new terrain();
                h.setId_terrain(rs.getInt("id_terrain"));
                h.setNom_terrain(rs.getString("nom_terrain"));
                h.setType_terrain(rs.getString("type_terrain"));
                h.setDescription_terrain(rs.getString("description_terrain"));
                h.setAdresse_terrain(rs.getString("adresse_terrain"));
                li.add(h);
                li.stream().sorted(comparator);
  //.forEach(a ->
   // System.out.println(a.getHeure_debut() + " " + a.getDate() + " " + a.getNom_T()+ " " + a.getNom_E()));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return li;
     }
      
      public terrain findByUsername(String nom_terrain){
          terrain h = new terrain();
         try {
            Statement st=cnx.createStatement();
            String query="select * from terrain where nom_terrain='"+nom_terrain+"'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next()){
                h.setId_terrain(rs.getInt("id_terrain"));
                h.setNom_terrain(rs.getString("nom_terrain"));
                h.setType_terrain(rs.getString("type_terrain"));
                h.setDescription_terrain(rs.getString("description_terrain"));
                h.setAdresse_terrain(rs.getString("adresse_terrain"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Serviceterrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return h;
     }
      
      public void reserver(terrain t) {
       try{
           String sql="UPDATE Terrain SET disponibilite = 'non' WHERE nom_terrain='"+t.getNom_terrain()+"'";
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Terrain a été reservé avec succée ");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }}
      
}


    

