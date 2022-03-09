/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Evenement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MYDB;
import java.util.Collections;
/**
 *
 * @author 
 */
public class Serviceevenement implements IService<Evenement> {
    
    private final Connection cnx;

    public Serviceevenement() {
        cnx = MYDB.getInstance().getConnection();
    }

      public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_evenement FROM evenement";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_evenement"));}
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
    public void ajouter(Evenement t) {
                String sql="insert into evenement(id_evenement,libelle_evenement,type_evenement,date_evenement) values(?,?,?,?)";
        try {
             int nextId = id_auto();
             
            PreparedStatement ste= cnx.prepareStatement(sql);
            java.sql.Date d = new java.sql.Date(t.getDate_evenement().getTime());
            ste.setInt(1, nextId);
             System.out.println(nextId);
             System.out.println(nextId);
            ste.setString(2, t.getLibelle_evenement());
            ste.setString(3, t.getType_evenement());
            ste.setDate(4,d);
            ste.executeUpdate();
            System.out.println(t.getId_evenement());
            System.out.println("evenement Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
        
        
    }

 

  public  void Modifier(Evenement e){
       try{
           String sql="UPDATE evenement SET libelle_evenement='"+e.getLibelle_evenement()
                   +"', type_evenement='"+e.getType_evenement()
                   +"',date_evenement='"+e.getDate_evenement()
                   +"' WHERE id_evenement="+e.getId_evenement();
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("evenement bien modifié");
           
       }catch(SQLException t){
           System.out.println(t.getMessage());
       }
       
       
   }

    @Override
    public void supprimer(int id_evenement) {
       try{
            String req = "DELETE FROM evenement WHERE id_evenement ='"+id_evenement+"'";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
       @Override
    public List<Evenement> afficher() {
             List<Evenement> list = new ArrayList<>();
        try{
            String req = "SELECT * FROM evenement";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Evenement c = new Evenement();
                c.setId_evenement(rs.getInt("id_evenement"));
                c.setLibelle_evenement(rs.getString("libelle_evenement")); 
                c.setType_evenement(rs.getString("type_evenement"));
                c.setDate_evenement(rs.getDate("date_evenement"));

                list.add(c);
            }
    } catch(SQLException m){
            System.err.println(m.getMessage());
        }
        return list ;   }
    public List<Evenement> afficherid(int id) {
        List <Evenement> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM evenement where id_evenement ='"+id+"'";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                Evenement c = new Evenement();
                c.setId_evenement(rs.getInt("id_evenement"));
                 System.out.println(c.getId_evenement());
                c.setLibelle_evenement(rs.getString("libelle_evenement"));
                 System.out.println(c.getLibelle_evenement());
                c.setType_evenement(rs.getString("type_evenement"));
                 System.out.println(c.getType_evenement());
                  c.setDate_evenement(rs.getDate("date_evenement"));
                   System.out.println(c.getDate_evenement());
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
      public int nb_evenement(List<Evenement> l)
   {
       return l.size();
   }

    @Override
    public void modifier(Evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
    




    
