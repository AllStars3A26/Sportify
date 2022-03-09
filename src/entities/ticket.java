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
public class ticket {
     private int id_ticket ;
    private int prix_ticket;
    private Date date_ticket ;
    private String libelle_ticket ;
    private String type_ticket;
    private Button modifier1;
    private Button supprimer1;
    
  

    public ticket() {
    }

    public ticket(int id_ticket, int prix_ticket, Date date_ticket, String libelle_ticket, String type_ticket) {
        this.id_ticket = id_ticket;
        this.prix_ticket = prix_ticket;
        this.date_ticket = date_ticket;
        this.libelle_ticket = libelle_ticket;
        this.type_ticket = type_ticket;
        
    }

    public ticket( int prix_ticket, Date date_ticket, String libelle_ticket, String type_ticket) {
        this.prix_ticket = prix_ticket;
        this.date_ticket = date_ticket;
        this.libelle_ticket= libelle_ticket;
        this.type_ticket = type_ticket;
        
    }

    public ticket(int i, String prixAjout, String libelleAjout, String typeAjout, Date dateAjout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ticket(String prixAjout, Date dateAjout, String libelleAjout, String typeAjout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getPrix_ticket() {
        return prix_ticket;
    }

    public void setPrix_ticket(int prix_ticket) {
        this.prix_ticket = prix_ticket;
    }

    public Date getDate_ticket() {
        return date_ticket;
    }

    public void setDate_ticket(Date date_ticket) {
        this.date_ticket = date_ticket;
    }

    public String getLibelle_ticket() {
        return libelle_ticket;
    }

    public void setLibelle_ticket(String libelle_ticket) {
        this.libelle_ticket = libelle_ticket;
    }

    public String getType_ticket() {
        return type_ticket;
    }

    public void setType_ticket(String type_ticket) {
        this.type_ticket = type_ticket;
    }

    public Button getModifier() {
        return modifier1;
    }

    public void setModifier(Button modifier) {
        this.modifier1 = modifier;
    }

    public Button getSupprimer() {
        return supprimer1;
    }

    public void setSupprimer(Button supprimer) {
        this.supprimer1 = supprimer;
    }

    
    

   

    @Override
    public String toString() {
        return "ticket{" + "id_ticket=" + id_ticket + ", prix_ticket=" + prix_ticket + ", date_ticket=" + date_ticket + ", libelle_ticket=" + libelle_ticket + ", type_ticket=" + type_ticket +  '}';
    }
    
}
