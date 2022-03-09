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
 * @author ASUS
 */
public class equipe {
 private int id_equipe ;
 private String nom_equipe ;
 private String type_equipe ;
 private String description_equipe ;
 private String mail_equipe ;
 private int nbre_joueur ;
 private Button modifier;
    private Button supprimer;

    public equipe() {
    }

    public equipe(int id_equipe, String nom_equipe, String type_equipe, String description_equipe, String mail_equipe, int nbre_joueur) {
        this.id_equipe = id_equipe;
        this.nom_equipe = nom_equipe;
        this.type_equipe = type_equipe;
        this.description_equipe = description_equipe;
        this.mail_equipe = mail_equipe;
        this.nbre_joueur = nbre_joueur;
    }

    public equipe(String nom_equipe, String type_equipe, String description_equipe, String mail_equipe, int nbre_joueur) {
        this.nom_equipe = nom_equipe;
        this.type_equipe = type_equipe;
        this.description_equipe = description_equipe;
        this.mail_equipe = mail_equipe;
        this.nbre_joueur = nbre_joueur;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    public String getType_equipe() {
        return type_equipe;
    }

    public void setType_equipe(String type_equipe) {
        this.type_equipe = type_equipe;
    }

    public String getDescription_equipe() {
        return description_equipe;
    }

    public void setDescription_equipe(String description_equipe) {
        this.description_equipe = description_equipe;
    }

    public String getMail_equipe() {
        return mail_equipe;
    }

    public void setMail_equipe(String mail_equipe) {
        this.mail_equipe = mail_equipe;
    }

    public int getNbre_joueur() {
        return nbre_joueur;
    }

    public void setNbre_joueur(int nbre_joueur) {
        this.nbre_joueur = nbre_joueur;
    }
    
    public Button getModifier() {
        return modifier;
    }

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }

    public Button getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(Button supprimer) {
        this.supprimer = supprimer;
    }

    
    @Override
    public String toString() {
        return "match{" + "id_equipe=" + id_equipe + ", nom_equipe=" + nom_equipe + ", type_equipe=" + type_equipe + ", description_equipe=" + description_equipe + ", mail_equipe=" + mail_equipe + ", nbre_joueur=" + nbre_joueur + '}';
    }
 
 
}
