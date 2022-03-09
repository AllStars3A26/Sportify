/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Evenement;
import entities.ticket;
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
public class Serviceticket implements IService<ticket> {

    
    private Connection cnx;

    public Serviceticket() {
        cnx = MYDB.getInstance().getConnection();
    }
    
      public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_ticket FROM ticket";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_ticket"));}
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
    public void ajouter(ticket t) {
       
        String sql="insert into ticket(id_ticket,prix_ticket,date_ticket,libelle_ticket,type_ticket) values(?,?,?,?,?)";
        try {
             int nextId = id_auto();
            PreparedStatement ste= cnx.prepareStatement(sql);
             java.sql.Date d = new java.sql.Date(t.getDate_ticket().getTime());
            ste.setInt(1, nextId);
            ste.setInt(2, t.getPrix_ticket());
            ste.setDate(3, d);
            ste.setString(4, t.getLibelle_ticket());
            ste.setString(5, t.getType_ticket());
            ste.executeUpdate();
            System.out.println("Ticket Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
        
        
    }



    @Override
    public void modifier(ticket t) {
       try{
            String req = "UPDATE ticket SET prix_ticket = ?, date_ticket = ?, libelle_ticket= ?, type_ticket= ?  WHERE id_ticket= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        java.sql.Date d = new java.sql.Date(t.getDate_ticket().getTime());
        ps.setInt(1,t.getPrix_ticket());
        ps.setDate(2,d);
        ps.setString(3,t.getLibelle_ticket());
        ps.setString(4,t.getType_ticket());
        ps.setInt(5,t.getId_ticket());
         System.out.println("Modification...");
         ps.executeUpdate();
      
        System.out.println("Une ligne modifiée dans la table...");
       }
       catch(SQLException e){
           
       }}

    @Override
    public void supprimer(int id_ticket) {
       try{
            String req = "DELETE FROM ticket WHERE id_ticket = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id_ticket);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
    @Override
   public List<ticket> afficher() {
        List <ticket> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM ticket";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                ticket c = new ticket();
                c.setId_ticket(rs.getInt("id_ticket"));
                c.setPrix_ticket(rs.getInt("prix_ticket"));
                 c.setDate_ticket(rs.getDate("date_ticket")); 
                  c.setLibelle_ticket(rs.getString("libelle_ticket"));
                  c.setType_ticket(rs.getString("type_ticket"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
   public List<ticket> afficherId(int id_ticket) {
        List <ticket> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM ticket where id_ticket="+id_ticket;
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                ticket c = new ticket();
                c.setId_ticket(rs.getInt("id_ticket"));
                c.setPrix_ticket(rs.getInt("prix_ticket"));
                 c.setDate_ticket(rs.getDate("date_ticket")); 
                  c.setLibelle_ticket(rs.getString("libelle_ticket"));
                  c.setType_ticket(rs.getString("type_ticket"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
      public int nb_tournoi(List<ticket> l)
   {
       return l.size();
   }

    public int nb_ticket(List<ticket> lt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
