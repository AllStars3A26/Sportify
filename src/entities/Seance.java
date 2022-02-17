/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Lenovo
 */
public class Seance {
    private int id;
    private String date,hrd,nom_T,nom_E;
    
    public Seance (){
        
        
    }
    public Seance(int id, String date, String heure_debut, String nom_T,String nom_E) {
        this.id = id;
        this.date = date;
        this.hrd = heure_debut;
        this.nom_T = nom_T;
        this.nom_E= nom_E;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure_debut() {
        return hrd;
    }

    public void setHeure_debut(String heure_debut) {
        this.hrd = heure_debut;
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
        return "Seance{" + "id=" + id + ", date=" + date + ", heure_debut=" + hrd + ", nom_T=" + nom_T +", nom_Entreineur=" + nom_E + '}';
    }

   
    
    
    
}
