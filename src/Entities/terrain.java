/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.Date;
import javafx.scene.control.Button;
/**
 *
 * @author ASUS
 */
public class terrain {
    private int id_terrain ;
    private String nom_terrain ;
    private String type_terrain ;
    private String description_terrain ;
    private String adresse_terrain ;
    private String disponibilite ;
    
     private Button modifier;
    private Button supprimer;
    
  

    public terrain() {
    }
    
    public terrain( String nom_terrain, String type_terrain, String description_terrain, String adresse_terrain) {
        this.nom_terrain = nom_terrain;
        this.type_terrain = type_terrain;
        this.description_terrain = description_terrain;
        this.adresse_terrain = adresse_terrain;
    }
    public terrain(int id_terrain, String nom_terrain, String type_terrain, String description_terrain, String adresse_terrain,String disponibilite) {
        this.id_terrain = id_terrain;
        this.nom_terrain = nom_terrain;
        this.type_terrain = type_terrain;
        this.description_terrain = description_terrain;
        this.adresse_terrain = adresse_terrain;
        this.disponibilite = disponibilite;
    }
    
    public terrain( String nom_terrain, String type_terrain, String description_terrain, String adresse_terrain, String disponibilite) {
        this.nom_terrain = nom_terrain;
        this.type_terrain = type_terrain;
        this.description_terrain = description_terrain;
        this.adresse_terrain = adresse_terrain;
        this.disponibilite = disponibilite;
    }

    public int getId_terrain() {
        return id_terrain;
    }

    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public String getNom_terrain() {
        return nom_terrain;
    }

    public void setNom_terrain(String nom_terrain) {
        this.nom_terrain = nom_terrain;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getType_terrain() {
        return type_terrain;
    }

    public void setType_terrain(String type_terrain) {
        this.type_terrain = type_terrain;
    }

    public String getDescription_terrain() {
        return description_terrain;
    }

    public void setDescription_terrain(String description_terrain) {
        this.description_terrain = description_terrain;
    }

    public String getAdresse_terrain() {
        return adresse_terrain;
    }

    public void setAdresse_terrain(String adresse_terrain) {
        this.adresse_terrain = adresse_terrain;
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
        return "terrain:" + "    |    " + nom_terrain + "    |    " + type_terrain + "    |    " + description_terrain + "    |    " + adresse_terrain ;
    }
    
    
}
