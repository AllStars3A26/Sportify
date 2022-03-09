/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

//import java.util.Date;
import java.util.Comparator;
import java.util.Date;
import javafx.scene.control.Button;

/**
 *
 * @author Lenovo
 */
public class Seance  {
    private int id_seance,nb_participants,heure_seance;

     private Button modifierSeance;
    private Button supprimerSeance;

    public Button getModifierSeance() {
        return modifierSeance;
    }

    public void setModifierSeance(Button modifierSeance) {
        this.modifierSeance = modifierSeance;
    }

    public Button getSupprimerSeance() {
        return supprimerSeance;
    }

    public void setSupprimerSeance(Button supprimerSeance) {
        this.supprimerSeance = supprimerSeance;
    }

    private String nom_T,nom_E;
    private Date date_seance;
    
    public Seance (){
        
        
    }
    public Seance(Date date, int heure_debut, String nom_T,String nom_E) {
        
        this.date_seance = date;
        this.heure_seance = heure_debut;
        this.nom_T = nom_T;
        this.nom_E= nom_E;
    } 
    public int getNb_participants() {
        return nb_participants;
    }

    public void setNb_participants(int nb_participants) {
        this.nb_participants = nb_participants;
    }
    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id) {
        this.id_seance = id;
    }

    public Date getDate_seance() {
        return date_seance;
    }

    public void setDate_seance(Date date) {
        this.date_seance = date;
    }

    public int getHeure_debut() {
        return heure_seance;
    }

    public void setHeure_debut(int heure_debut) {
        this.heure_seance = heure_debut;
    }

    public String getNom_T() {
        return nom_T;
    }

    public void setNom_T(String nom_T) {
        this.nom_T = nom_T;
    }

    public String getNom_E() {
        return nom_E;
    }

    public void setNom_E(String nom_E) {
        this.nom_E = nom_E;
    }

    @Override
    public String toString() {
        return "Seance{" +" date=" + date_seance + ", heure_debut=" + heure_seance + ", nom_T=" + nom_T +", nom_Entreineur=" + nom_E + '}';
    }
  
  

    

   
    
    
    
}
