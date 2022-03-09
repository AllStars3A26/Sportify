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
 * @author yassi
 */
public class Evenement {
 private int id_evenement;
 private String type_evenement;
 private Date date_evenement ;
 private String libelle_evenement ;
 private Button modifier;
    private Button supprimer;

    public Evenement() {
    }

    public Evenement(int id_evenement,String libelle_evenement, String type_evenement, Date date_evenement) {
        this.id_evenement = id_evenement;
        this.type_evenement= type_evenement;
        this.libelle_evenement = libelle_evenement;
        this.date_evenement = date_evenement;
        
    }

    
    public Evenement(String libelle_evenement, String type_evenement,  Date date_evenement) {
        
        this.libelle_evenement = libelle_evenement;
        this.type_evenement= type_evenement;
        this.date_evenement= date_evenement;
        
        
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

 

    public String getType_evenement() {
        return type_evenement;
    }

    public void setType_evenement(String type_evenement) {
        this.type_evenement = type_evenement;
    }

    public Date getDate_evenement() {
        return date_evenement;
    }

    public void setDate_evenement(Date date_evenement) {
        this.date_evenement = date_evenement;
    }

    public String getLibelle_evenement() {
        return libelle_evenement;
    }

    public void setLibelle_evenement(String libelle_evenement) {
        this.libelle_evenement = libelle_evenement;
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
        return "evenement{" + "id_evenement=" + id_evenement + ", type_evenement=" +type_evenement + ", libelle_evenement=" + libelle_evenement + ", date_evenement=" + date_evenement +  '}';
    }
 
}
