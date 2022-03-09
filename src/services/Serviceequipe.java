/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.equipe;
import entities.terrain;
import entities.SendMail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MYDB;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author ASUS
 */
public class Serviceequipe implements IService<equipe> {
    
    private Connection cnx;

    public Serviceequipe() {
        cnx = MYDB.getInstance().getConnection();
    }

      public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_equipe FROM equipe";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_equipe"));}
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
    public void ajouter(equipe t) {
                String sql="insert into equipe(id_equipe,nom_equipe,type_equipe,description_equipe,mail_equipe,nbre_joueur) values(?,?,?,?,?,?)";
        try {
            int nextId = id_auto();
            PreparedStatement ste= cnx.prepareStatement(sql);
            ste.setInt(1,nextId);
            ste.setString(2, t.getNom_equipe());
            ste.setString(3, t.getType_equipe());
            ste.setString(4,t.getDescription_equipe());
            ste.setString(5, t.getMail_equipe());
            ste.setInt(6, t.getNbre_joueur());
            ste.executeUpdate();
            System.out.println("equipe equipe");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}

 

    @Override
    public void modifier(equipe t) {
   try{
            String req = "UPDATE equipe SET type_equipe='"+t.getType_equipe()+"',description_equipe='"+t.getDescription_equipe()+"',mail_equipe='"+t.getNbre_joueur()+"' WHERE nom_equipe='"+t.getNom_equipe()+"'";
        PreparedStatement ste = cnx.prepareStatement(req);
           ste.executeUpdate(req);
           System.out.println("Terrain bien modifié");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }}

    @Override
    public void supprimer(int id) {
       try{
            String req = "DELETE FROM equipe WHERE id_equipe = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
       @Override
    public List<equipe> afficher() {
             List<equipe> list = new ArrayList<>();
        try{
            String req = "SELECT * FROM equipe";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                equipe m = new equipe();
              m.setId_equipe(rs.getInt(1));
              m.setNom_equipe(rs.getString(2));
              m.setType_equipe(rs.getString(3));
              m.setDescription_equipe(rs.getString(4));
              m.setMail_equipe(rs.getString(5));
              m.setNbre_joueur(rs.getInt(6));
              
                
                list.add(m);
            }
    }

  
        catch(SQLException m){
            
        }
        return list ;   }
    
    public List<equipe> afficherId(int id) {
        List <equipe> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM equipe where id_Equipe="+id;
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                equipe c = new equipe();
                c.setId_equipe(rs.getInt("id_equipe"));
                c.setNom_equipe(rs.getString("nom_equipe"));
                 c.setType_equipe(rs.getString("type_equipe")); 
                  c.setDescription_equipe(rs.getString("description_equipe"));
                  c.setMail_equipe(rs.getString("mail_equipe"));
                  c.setNbre_joueur(rs.getInt("nbre_joueur"));
               
              
               
                st.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
      public int nb_terrain(List<equipe> l)
   {
       return l.size();
   }
      
      public List<equipe> rechercheequipe(Object a){
       List <equipe> st = new ArrayList<>();
        String query = null;
        if(a instanceof String){
        query = "select * from equipe where nom_equipe LIKE '"+a+"%' OR nom_equipe LIKE '%"+a+"' OR nom_equipe LIKE '%"+a+"%' OR type_equipe LIKE '"+a+"%' OR type_equipe LIKE '%"+a+"' OR type_equipe LIKE '%"+a+"%' OR description_equipe LIKE '"+a+"%' OR description_equipe LIKE '%"+a+"' OR description_equipe LIKE '%"+a+"%' OR mail_equipe LIKE '"+a+"%' OR mail_equipe LIKE '%"+a+"' OR mail_equipe LIKE '%"+a+"%'     ";
     }else if(a instanceof Integer){
        query="select * from equipe where nbre_joueur>="+a+"";
     }
        try {
            PreparedStatement ste;
            ste = cnx.prepareStatement(query);
            ResultSet rs;
            rs = ste.executeQuery();
            //rs.next();
            while(rs.next()){
                equipe h = new equipe();
                
                  h.setId_equipe(rs.getInt("id_equipe"));
                  h.setNom_equipe(rs.getString("nom_equipe"));
                  h.setType_equipe(rs.getString("type_equipe")); 
                  h.setDescription_equipe(rs.getString("description_equipe"));
                  h.setMail_equipe(rs.getString("mail_equipe"));
                  h.setNbre_joueur(rs.getInt("nbre_joueur"));
                
                
                st.add(h);
                
                //rs.next();
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return st;
        

        
       
    }
      
      
      public  List<equipe> TrierParnom(){
         Comparator<equipe> comparator =
  Comparator.comparing(equipe::getNom_equipe).thenComparing(equipe::getType_equipe).reversed();
          List<equipe> li = new ArrayList<>();
        String query="select * from equipe";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                equipe h = new equipe();
                  h.setId_equipe(rs.getInt("id_equipe"));
                  h.setNom_equipe(rs.getString("nom_equipe"));
                  h.setType_equipe(rs.getString("type_equipe")); 
                  h.setDescription_equipe(rs.getString("description_equipe"));
                  h.setMail_equipe(rs.getString("mail_equipe"));
                  h.setNbre_joueur(rs.getInt("nbre_joueur"));
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

    public String getEmailbyUsername(String text) {
       String str = "";
        try {
            String request = "SELECT mail_equipe FROM equipe where nom_equipe='"+text+"'";
            Statement s = cnx.createStatement();
            ResultSet result = s.executeQuery(request);
            while (result.next()) {
                str = result.getString("email");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return str;//To change body of generated methods, choose Tools | Templates.
    }
}
    
    
