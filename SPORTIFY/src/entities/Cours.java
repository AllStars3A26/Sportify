/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.scene.control.Button;

/**
 *
 * @author Lenovo
 */
public class Cours {
    private int id_cours,nb_heure;
    private String type , imc ,titre , nomE;
    private Button modifierCours;
    private Button supprimerCours;

    public Button getModifierCours() {
        return modifierCours;
    }

    public void setModifierCours(Button modifierCours) {
        this.modifierCours = modifierCours;
    }

    public Button getSupprimerCours() {
        return supprimerCours;
    }

    public void setSupprimerCours(Button supprimerCours) {
        this.supprimerCours = supprimerCours;
    }

    public Cours ()
    {
        
    }
    public Cours( int id ,String titre, String nome, String type, String imc,int nb_heure) {
        this.id_cours = id;
        this.nb_heure = nb_heure;
        this.type = type;
        this.imc = imc;
        this.titre = titre;
        this.nomE = nome;
    }
     public Cours( String titre, String nome, String type, String imc,int nb_heure) {
        
        this.nb_heure = nb_heure;
        this.type = type;
        this.imc = imc;
        this.titre = titre;
        this.nomE = nome;
    }

   
    public int getId_cours() {
         
        return id_cours;
    }


    public void setId_cours(int id) {
        this.id_cours = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public String gettitre() {
        return titre;
    }

    public int getNb_heure() {
        return nb_heure;
    }

    public void setNb_heure(int nb_heure) {
        this.nb_heure = nb_heure;
    }

    public void settitre(String nomC) {
        this.titre = nomC;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    @Override
    public String toString() {
        return "Cours{"+" description du cours=" + type + ", impact physique =" + imc + ", titre=" + titre + ", nom_entreineur=" + nomE + '}';
    }
    
}
