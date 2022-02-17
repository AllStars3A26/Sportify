/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



/**
 *
 * @author emnat
 */
public class Adherant extends User {
private String date_inscrit;

    public Adherant() {
    }

    public Adherant(String date_inscrit) {
        this.date_inscrit = date_inscrit;
    }

    public Adherant(String date_inscrit, String nom_user, String prenom_user, String adresse_user, String login_user, String password_user) {
        super(nom_user, prenom_user, adresse_user, login_user, password_user);
        this.date_inscrit = date_inscrit;
    }

  
   

    public String getDate_inscrit() {
        return date_inscrit;
    }

    public void setDate_inscrit(String date_inscrit) {
        this.date_inscrit = date_inscrit;
    }

   /* @Override
    public String toString() {
        return "Adherant{" + "date_inscrit=" + date_inscrit + '}';
    }*/
  
    
    
}
