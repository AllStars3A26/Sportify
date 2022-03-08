/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Date;
import javafx.scene.control.Button;
/**
 *
 * @author Sahar Zouari
 */
public class tournoi {
    private int id_tournoi ;
    private String nom_tournoi ;
    private Date date_tournoi ;
    private int nb_participants ;
    private String image_tournoi ;
    private int resultat_tournoi;
    private int heure;
     private Button modifier;
    private Button supprimer;
    
  

    public tournoi() {
    }

    public tournoi(int id_tournoi, String nom_tournoi, Date date_tournoi, int nb_participants, String image_tournoi,int resultat_tournoi,int heure) {
        this.id_tournoi = id_tournoi;
        this.nom_tournoi = nom_tournoi;
        this.date_tournoi = date_tournoi;
        this.nb_participants = nb_participants;
        this.image_tournoi = image_tournoi;
        this.resultat_tournoi = resultat_tournoi;
        this.heure=heure;
    }

    public tournoi(int id_tournoi, String nom_tournoi, Date date_tournoi, int nb_participants, int resultat_tournoi, int heure) {
        this.id_tournoi = id_tournoi;
        this.nom_tournoi = nom_tournoi;
        this.date_tournoi = date_tournoi;
        this.nb_participants = nb_participants;
        this.resultat_tournoi = resultat_tournoi;
        this.heure = heure;
    }

    public tournoi(String nom_tournoi, Date date_tournoi, int nb_participants, String image_tournoi, int resultat_tournoi,int heure) {
        this.nom_tournoi = nom_tournoi;
        this.date_tournoi = date_tournoi;
        this.nb_participants = nb_participants;
        this.image_tournoi = image_tournoi;
        this.resultat_tournoi = resultat_tournoi;
        this.heure=heure;
    }
    

    public void setResultat_tournoi(int resultat_tournoi) {
        this.resultat_tournoi = resultat_tournoi;
    }

    public int getResultat_tournoi() {
        return resultat_tournoi;
    }

    public Button getModifier() {
        return modifier;
    }

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
    
    public void setSupprimer(Button supprimer) {
        this.supprimer = supprimer;
    }

    public Button getSupprimer() {
        return supprimer;
    }

   

    public int getId_tournoi() {
        return id_tournoi;
    }

    public String getNom_tournoi() {
        return nom_tournoi;
    }

    public Date getDate_tournoi() {
        return date_tournoi;
    }

    public int getNb_participants() {
        return nb_participants;
    }

    public String getImage_tournoi() {
        return image_tournoi;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public void setNom_tournoi(String nom_tournoi) {
        this.nom_tournoi = nom_tournoi;
    }

    public void setDate_tournoi(Date date_tournoi) {
        this.date_tournoi = date_tournoi;
    }

    public void setNb_participants(int nb_participants) {
        this.nb_participants = nb_participants;
    }

    public void setImage_tournoi(String image_tournoi) {
        this.image_tournoi = image_tournoi;
    }

    @Override
    public String toString() {
        return "tournoi{" + "id_tournoi=" + id_tournoi + ", nom_tournoi=" + nom_tournoi + ", date_tournoi=" + date_tournoi + ", nb_participants=" + nb_participants + ", image_tournoi=" + image_tournoi + ", resultat_tournoi=" + resultat_tournoi + '}';
    }

    public void setNom_equipe(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_participant(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_equipe(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
