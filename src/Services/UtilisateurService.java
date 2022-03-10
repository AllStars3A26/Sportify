/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Adhérent;
import Entities.Entraineur;
import Entities.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;
import tools.MaConnexion;
/**
 *
 * @author Lenovo
 */
public class UtilisateurService {
        Connection cnx;

    public UtilisateurService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
        public void ajouterUtilisateur(Utilisateur U){
           if (rechercheUparnom(U.getNom(),U.getPrenom())!=0) {
                System.out.println("Utilisateur (admin ou Entraineur ou adhérent ) deja ajoutee ");
            }
           else{
      String hashed = BCrypt.hashpw(U.getPwd(), BCrypt.gensalt());

           ///// pour ajouter un Adhérent marcheee
           if (U instanceof Adhérent){
               Adhérent U1=(Adhérent) U;
               String sql="INSERT INTO `Utilisateur`(`nom`, `prenom`, `adresse`, `login`, `pwd`, `role`,`descB_A`, `email`, `image`) VALUES  ('"+U1.getNom()+"','"+U1.getPrenom()+"','"+U1.getAdresse()+"','"+U1.getLogin()+"','"+hashed+"','"+U1.getRole()+"','"+U1.getDesc()+"','"+U1.getEmail()+"','"+U1.getImage()+"')";
            try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Adhérent Ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           }
          /////////////////////////////////////
           else if (U instanceof Entraineur) {
               Entraineur U1= (Entraineur)U;
                 String sql="INSERT INTO `Utilisateur`(`nom`, `prenom`, `adresse`, `login`, `pwd`, `role`, `email`, `type_E`,`date_contract`,`dure_contract`,`num`) VALUES  ('"+U1.getNom()+"','"+U1.getPrenom()+"','"+U1.getAdresse()+"','"+U1.getLogin()+"','"+hashed+"','"+U1.getRole()+"','"+U1.getEmail()+"','"+U1.getType_E()+"','"+U1.getDate_contract()+"','"+U1.getDure()+"','"+U1.getNum()+"')";
            try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Entraineur Ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           } 
           
           
           else {
            String sql="INSERT INTO `Utilisateur`(`nom`, `prenom`, `adresse`, `login`, `pwd`, `role`, `email`) VALUES  ('"+U.getNom()+"','"+U.getPrenom()+"','"+U.getAdresse()+"','"+U.getLogin()+"','"+hashed+"','"+U.getRole()+"','"+U.getEmail()+"')";
            try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Admin Ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
            
            
            
            
        }
        }
        }
         public boolean verifierEmailBd(String email) {
	PreparedStatement stmt = null;
	ResultSet rst = null;
	try {
	    String sql = "SELECT * FROM Utilisateur WHERE email=?";
	    stmt = cnx.prepareStatement(sql);
	    stmt.setString(1, email);
	    rst = stmt.executeQuery();
	    if (rst.next()) {
		return true;
	    }
	} catch (SQLException ex) {
	    System.out.println(ex.getMessage());
	}
	return false;
    }
         public boolean verifierUsername(String email) {
	PreparedStatement stmt = null;
	ResultSet rst = null;
	try {
	    String sql = "SELECT * FROM Utilisateur WHERE login=?";
	    stmt = cnx.prepareStatement(sql);
	    stmt.setString(1, email);
	    rst = stmt.executeQuery();
	    if (rst.next()) {
		return true;
	    }
	} catch (SQLException ex) {
	    System.out.println(ex.getMessage());
	}
	return false;
    }
    
public  int rechercheUparnom(String nom,String prenom){
         int nbrRow=0;
        try{
          String sql="SELECT * FROM Utilisateur WHERE nom='"+nom+"' AND prenom='"+prenom+"'"; 
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




public List<Utilisateur> afficherUtilisateur(){
        List<Utilisateur> listt = new ArrayList<>();
        String query="select * from Utilisateur";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                System.out.println("hello");
                if (rs.getInt("role")== 0){
                  Utilisateur c = new Utilisateur();
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAdresse(rs.getString("adresse"));
                c.setLogin(rs.getString("login"));
                c.setPwd(rs.getString("pwd"));
                c.setRole(rs.getInt("role"));
                listt.add(c);
                }
                else if (rs.getInt("role")== 1){
                    Adhérent c1=new Adhérent();
                c1.setNom(rs.getString("nom"));
                c1.setPrenom(rs.getString("prenom"));
                c1.setAdresse(rs.getString("adresse"));
                c1.setLogin(rs.getString("login"));
                c1.setPwd(rs.getString("pwd"));
                c1.setRole(rs.getInt("role"));
                c1.setDate_inscrit(rs.getDate("Date_inscrit_A"));
                c1.setDesc(rs.getString("DescB_A"));
                c1.setImage(rs.getString("image"));
                listt.add(c1);
                }
                else {
                    Entraineur e= new Entraineur();
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setAdresse(rs.getString("adresse"));
                e.setLogin(rs.getString("login"));
                e.setPwd(rs.getString("pwd"));
                e.setRole(rs.getInt("role"));
                e.setDure(rs.getInt("dure_contract"));
                e.setType_E(rs.getString("type_E"));
                e.setDate_contract(rs.getDate("date_contract"));
                e.setNum(rs.getString("num"));
                listt.add(e);
                }
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listt;
        
    }
 public void supprimerEntraineur(int id) {
       try{
            String req = "DELETE FROM Utilisateur WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1,id);

ps.executeUpdate();
            System.out.println("Une ligne SUPPRIMER dans la table...");
       }
       catch(SQLException e){
           
       }}
public List<Entraineur> afficherEntraineur(){
        List<Entraineur> listt = new ArrayList<>();
        String query="select * from Utilisateur where role ='"+2+"'";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){

                    Entraineur e= new Entraineur();
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setAdresse(rs.getString("adresse"));
                e.setLogin(rs.getString("login"));
                e.setPwd(rs.getString("pwd"));
                e.setEmail(rs.getString("email"));
                e.setDure(rs.getInt("dure_contract"));
                e.setType_E(rs.getString("type_E"));
                e.setDate_contract(rs.getDate("date_contract"));
                e.setNum(rs.getString("num"));
                e.setid(rs.getInt("id"));
                listt.add(e);
                }
                
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listt;
        
    }
public List<Utilisateur> afficherAdmin(){
        List<Utilisateur> listt = new ArrayList<>();
        String query="select * from Utilisateur where role ='"+0+"'";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){

                    Utilisateur c = new Utilisateur();
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAdresse(rs.getString("adresse"));
                c.setLogin(rs.getString("login"));
                c.setPwd(rs.getString("pwd"));
                c.setEmail(rs.getString("email"));
                c.setid(rs.getInt("id"));
                listt.add(c);
                }
                
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listt;
        
    }
public List<Adhérent> afficherAdhérent(){
        List<Adhérent> listt = new ArrayList<>();
        String query="select * from Utilisateur where role ='"+1+"'";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){

                Adhérent c1=new Adhérent();
                c1.setNom(rs.getString("nom"));
                c1.setPrenom(rs.getString("prenom"));
                c1.setAdresse(rs.getString("adresse"));
                c1.setLogin(rs.getString("login"));
                c1.setPwd(rs.getString("pwd"));
                c1.setDate_inscrit(rs.getDate("Date_inscrit_A"));
                c1.setDesc(rs.getString("DescB_A"));
                c1.setEmail(rs.getString("email"));
                c1.setid(rs.getInt("id"));
                c1.setImage(rs.getString("image"));
                listt.add(c1);
                
                }
                
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listt;
        
    }
     public  void SupprimerParidentificateur(String nom,String prenom){
        try{
           String sql="DELETE FROM Utilisateur WHERE nom='"+nom+"'AND prenom='"+prenom+"'AND role!='"+0+"'"; 
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Utilisateur supprimé");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
           public  void ModifierUtilisateur( String nom, String prenom, String adresse, String login, String pwd,String email ){
       try{
           String hashed = BCrypt.hashpw(pwd, BCrypt.gensalt());
           String sql="UPDATE Utilisateur SET adresse='"+adresse+"', login='"+login+"',pwd='"+hashed+"'email='"+email+"' WHERE nom='"+nom+"' AND prenom='"+prenom+"'";
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("les attributs des utilisateurs bien modifié");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       
       
   }
     public  void ModifierAdhérent( String nom, String prenom, String adresse, String login,String email,String descB_A ){
       try{
           
           String sql="UPDATE Utilisateur SET adresse='"+adresse+"', login='"+login+"',email='"+email+"',descB_A='"+descB_A+"' WHERE nom='"+nom+"' AND prenom='"+prenom+"'";
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Adhérent bien modifié");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       
       
   }
     public List<Entraineur> afficherIdEntraineur(int id) {
        List <Entraineur> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM UTILISATEUR where id='"+id+"' AND role='"+2+"'";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                Entraineur e= new Entraineur();
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setAdresse(rs.getString("adresse"));
                e.setLogin(rs.getString("login"));
                e.setPwd(rs.getString("pwd"));
                e.setRole(rs.getInt("role"));
                e.setDure(rs.getInt("dure_contract"));
                e.setType_E(rs.getString("type_E"));
                e.setDate_contract(rs.getDate("date_contract"));
                e.setNum(rs.getString("num"));
                st.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
     public List<Adhérent> afficherIdAdhérent(int id) {
        List <Adhérent> st = new ArrayList<>();
        try {
            String requete = "SELECT * FROM UTILISATEUR where id='"+id+"' AND role='"+1+"'";
            Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(requete);
            while(rs.next()){
                  Adhérent c1=new Adhérent();
                c1.setNom(rs.getString("nom"));
                c1.setPrenom(rs.getString("prenom"));
                c1.setAdresse(rs.getString("adresse"));
                c1.setLogin(rs.getString("login"));
                c1.setPwd(rs.getString("pwd"));
                c1.setDate_inscrit(rs.getDate("Date_inscrit_A"));
                c1.setDesc(rs.getString("DescB_A"));
                c1.setEmail(rs.getString("email"));
                c1.setid(rs.getInt("id"));
                st.add(c1);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
   public void ModifierEntraineur(String NomAjout,String PenomAjout,String AdresseAjout,String LoginAjout,String  numAjout,String  emailAjout,String  TypeAjout,int DureAjout,String Date_contractAjout){
       try{
            SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date udco=df.parse(Date_contractAjout);
        long ms=udco.getTime();
        java.sql.Date squdco= new java.sql.Date(ms);
        
           String sql="UPDATE Utilisateur SET type_E='"+TypeAjout+"',date_contract='"+squdco+"',num='"+numAjout+"',adresse='"+AdresseAjout+"',login='"+LoginAjout+"',email='"+emailAjout+"',dure_contract='"+DureAjout+"' WHERE nom='"+NomAjout+"' AND prenom='"+PenomAjout+"'";
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Entraineur  bien modifié");
           
       }catch(SQLException | ParseException e){
           System.out.println(e.getMessage());
       }
       
       
   }
   public Utilisateur findbyemail(String email){
        Utilisateur A1 = null;
        String query = "select * from Utilisateur where email=?";
        try {
           PreparedStatement pstmt = cnx.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               A1 = new Utilisateur(rs.getInt(7), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(10));
            }
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
        return A1;
    }
       public Boolean nomExist(String username) {

        try {
            String request = "SELECT nom FROM UTILISATEUR where nom='" + username + "'";
            Statement s = cnx.createStatement();
            ResultSet result = s.executeQuery(request);
            while (result.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
       public String getEmailbyUsername(String username) throws SQLException {

        
        String str = "";
        try {
            String request = "SELECT email FROM Utilisateur where nom='" + username + "'";
            Statement s = cnx.createStatement();
            ResultSet result = s.executeQuery(request);
            while (result.next()) {
                str = result.getString("email");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return str;
    }
       public String getimbyemail(String username) throws SQLException {

        
        String str = "";
        try {
            String request = "SELECT image FROM Utilisateur where email='" + username + "'";
            Statement s = cnx.createStatement();
            ResultSet result = s.executeQuery(request);
            while (result.next()) {
                str = result.getString("image");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return str;
    }
       public List<Adhérent> rechercheadhérent(Object a){
       List <Adhérent> st = new ArrayList<>();
        String query = null;
        if(a instanceof String){
        query = "select * from Utilisateur where nom LIKE '%"+a+"%' OR prenom LIKE '%"+a+"%' OR adresse LIKE '%"+a+"%' OR login LIKE '%"+a+"%' OR email LIKE '%"+a+"%' OR descB_A LIKE '%"+a+"%' AND role ='"+1+"'  ";
     }else if(a instanceof Integer){
        query="select * from Utilisateur where id>="+a+"";
     }
        try {
            PreparedStatement ste;
            ste = cnx.prepareStatement(query);
            ResultSet rs;
            rs = ste.executeQuery();
            //rs.next();
            while(rs.next()){
                  Adhérent c1=new Adhérent();
                c1.setNom(rs.getString("nom"));
                c1.setPrenom(rs.getString("prenom"));
                c1.setAdresse(rs.getString("adresse"));
                c1.setLogin(rs.getString("login"));
                c1.setPwd(rs.getString("pwd"));
                c1.setDate_inscrit(rs.getDate("Date_inscrit_A"));
                c1.setDesc(rs.getString("DescB_A"));
                c1.setEmail(rs.getString("email"));
                c1.setid(rs.getInt("id"));
                st.add(c1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return st;

    }
              public List<Entraineur> rechercheEntraineur(Object a){
       List <Entraineur> st = new ArrayList<>();
        String query = null;
        if(a instanceof String){
        query = "select * from Utilisateur where nom LIKE '%"+a+"' OR prenom LIKE '%"+a+"' OR adresse LIKE '%"+a+"' OR login LIKE '%"+a+"' OR email LIKE '%"+a+"' OR date_contract LIKE '%"+a+"' OR dure_contract LIKE '%"+a+"' OR num LIKE '%"+a+"' OR   Type_E LIKE '%"+a+"'";
     }else if(a instanceof Integer){
        query="select * from Utilisateur where id>="+a+"";
     }
        try {
            PreparedStatement ste;
            ste = cnx.prepareStatement(query);
            ResultSet rs;
            rs = ste.executeQuery();
            //rs.next();
            while(rs.next()){
              Entraineur e= new Entraineur();
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setAdresse(rs.getString("adresse"));
                e.setLogin(rs.getString("login"));
                e.setPwd(rs.getString("pwd"));
                e.setRole(rs.getInt("role"));
                e.setDure(rs.getInt("dure_contract"));
                e.setType_E(rs.getString("type_E"));
                e.setDate_contract(rs.getDate("date_contract"));
                e.setNum(rs.getString("num"));
                st.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return st;

    }
       public String getAlphaNumericString(int n) {

        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb 
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
       public int geIdbyemail(String username) throws SQLException {

        /* CurrentUser cu = CurrentUser.CurrentUser(); */
        int id = 0;
        try {
            String request = "SELECT id FROM Utilisateur where email='" + username + "'";
            Statement s = cnx.createStatement();
            ResultSet result = s.executeQuery(request);
            while (result.next()) {
                id = result.getInt("id");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
       public void updateCode(String code, int id) {
        /*CurrentUser cu = CurrentUser.CurrentUser();*/
        String sql = "UPDATE utilisateur SET code='" + code + "' WHERE id=" + id;
        try {
           Statement st = cnx.createStatement();
            st.executeUpdate(sql);
            System.out.println("code");
        } catch (SQLException ex) {
            Logger.getLogger(MaConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void updatePassword(Utilisateur user) {
        String requete = "UPDATE Utilisateur SET pwd='" + user.getPwd() + "',code=NULL WHERE prenom='" + user.getPrenom()+ "' AND nom='" + user.getNom()+ "'";
        try {
           Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("mot de passe modifié");
        } catch (SQLException ex) {
            Logger.getLogger(MaConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public Utilisateur findById(int id) {
        String query = "select * from utilisateur where id=?";
        Utilisateur A1 = null;
        try {
           PreparedStatement pstmt = cnx.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               A1 = new Utilisateur(rs.getInt(7), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return A1;
    }
     
}
