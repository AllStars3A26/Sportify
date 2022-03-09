/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Lenovo
 */
public class Compte {
    private String nom , prenom ,num_compte;
    private double solde;

    public Compte(){
        
    }
        
    public Compte(String nom, String prenom, String num_compte, double solde) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_compte = num_compte;
        this.solde = solde;
    }
        public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(String num_compte) {
        this.num_compte = num_compte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" + "nom=" + nom + ", prenom=" + prenom + ", num_compte=" + num_compte + ", solde=" + solde + '}';
    }
    
}
