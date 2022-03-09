/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.produit;
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
public class ServiceProduit implements IService<produit> {

    
    private Connection cnx;

    public ServiceProduit() {
        cnx = MYDB.getInstance().getConnection();
    }
    
      public int id_auto()
    { int j=1;
       boolean test = false;
        ArrayList st = new ArrayList<>();
        try {
            String requete = "SELECT id_prod FROM produit";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
               st.add(rs.getInt("id_prod"));}
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
    public void ajouter(produit t) {
       
        String sql="insert into produit(id_prod,nom_prod,prix_prod,quant_prod,img_prod,cat_prod,desc_prod) values(?,?,?,?,?,?,?)";
        try {
             int nextId = id_auto();
            PreparedStatement ste= cnx.prepareStatement(sql);

            ste.setInt(1, nextId);
            ste.setString(2, t.getNom_prod());
            ste.setFloat(3, t.getPrix_prod());
            ste.setInt(4, t.getQuant_prod());
            ste.setString(5, t.getImg_prod());
            ste.setString(6, t.getCat_prod());
            ste.setString(7, t.getDesc_prod());

            
            ste.executeUpdate();
            System.out.println("Produit Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
        
        
    }



    @Override
    public void modifier(produit t) {
       try{
            String req = "UPDATE produit SET nom_prod = ?, prix_produit = ?, quant_prod= ?, img_prod= ?, cat_prod= ? ,desc_prod=? WHERE id_produit= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
      
        ps.setString(1,t.getNom_prod());
        
        ps.setFloat(2,t.getPrix_prod());
        ps.setInt(3,t.getQuant_prod());
        ps.setString(4,t.getImg_prod());
        ps.setString(5,t.getCat_prod());
        ps.setString(6,t.getDesc_prod());
        ps.setInt(7,t.getId_prod());

         System.out.println("Modification...");
         ps.executeUpdate();
      
        System.out.println("Une ligne modifiée dans la table...");
       }
       catch(SQLException e){
           
       }}

    @Override
    public void supprimer(int id) {
       try{
            String req = "DELETE FROM produit WHERE id_prod = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
           @Override
   public List<produit> afficher() {
        List <produit> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM produit";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                produit p = new produit();
                p.setId_prod(rs.getInt("id_prod"));
                p.setNom_prod(rs.getString("nom_prod"));
                p.setPrix_prod(rs.getFloat("prix_prod")); 
                p.setQuant_prod(rs.getInt("quant_prod"));
                p.setImg_prod(rs.getString("img_prod"));
                p.setCat_prod(rs.getString("cat_prod"));
                p.setDesc_prod(rs.getString("desc_prod"));
               
              
               
                st.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
   public List<produit> afficherId(int id) {
        List <produit> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM produit where id_prod="+id;
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                 produit p = new produit();
                p.setId_prod(rs.getInt("id_prod"));
                p.setNom_prod(rs.getString("nom_prod"));
                p.setPrix_prod(rs.getFloat("prix_prod")); 
                p.setQuant_prod(rs.getInt("quant_prod"));
                p.setImg_prod(rs.getString("img_prod"));
                p.setCat_prod(rs.getString("cat_prod"));
                p.setDesc_prod(rs.getString("desc_prod"));
               
              
               
                st.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
}

