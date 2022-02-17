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
public class Entraineur extends User {
    private String type_contrat,dated_contrat;
    private int duree_contrat;



    public Entraineur(String type_contrat, String dated_contrat, int duree_contrat, int id_user, String nom_user, String prenom_user, String adresse_user, String login_user, String password_user) {
        super( nom_user, prenom_user, adresse_user, login_user, password_user);
        this.type_contrat = type_contrat;
        this.dated_contrat = dated_contrat;
        this.duree_contrat = duree_contrat;
    }

    public Entraineur() {
       
    }

    public String getType_contrat() {
        return type_contrat;
    }

    public String getDated_contrat() {
        return dated_contrat;
    }

    public int getDuree_contrat() {
        return duree_contrat;
    }

    public void setType_contrat(String type_contrat) {
        this.type_contrat = type_contrat;
    }

    public void setDated_contrat(String dated_contrat) {
        this.dated_contrat = dated_contrat;
    }

    public void setDuree_contrat(int duree_contrat) {
        this.duree_contrat = duree_contrat;
    }

   /* @Override
    public String toString() {
        return "Entraineur{" + "type_contrat=" + type_contrat + ", dated_contrat=" + dated_contrat + ", duree_contrat=" + duree_contrat + '}';
    }*/
    
    
}
