/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.scene.control.Button;

/**
 *
 * @author snowy
 */

public class produit {
    private int id_prod;
    private String nom_prod;
    private float prix_prod;
    private int quant_prod;
    private String img_prod,cat_prod,desc_prod;
     private Button modifier;
    private Button supprimer;
   public produit()
    {}

    public produit(int id_prod, String nom_prod, float prix_prod, int quant_prod, String img_prod, String cat_prod, String desc_prod) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.prix_prod = prix_prod;
        this.quant_prod = quant_prod;
        this.img_prod = img_prod;
        this.cat_prod = cat_prod;
        this.desc_prod = desc_prod;
        
    }
    public produit(String nom_prod, float prix_prod, int quant_prod, String img_prod, String cat_prod, String desc_prod) {
        
        this.nom_prod = nom_prod;
        this.prix_prod = prix_prod;
        this.quant_prod = quant_prod;
        this.img_prod = img_prod;
        this.cat_prod = cat_prod;
        this.desc_prod = desc_prod;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public float getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(float prix_prod) {
        this.prix_prod = prix_prod;
    }

    public int getQuant_prod() {
        return quant_prod;
    }

    public void setQuant_prod(int quant_prod) {
        this.quant_prod = quant_prod;
    }

    public String getImg_prod() {
        return img_prod;
    }

    public void setImg_prod(String img_prod) {
        this.img_prod = img_prod;
    }

    public String getCat_prod() {
        return cat_prod;
    }

    public void setCat_prod(String cat_prod) {
        this.cat_prod = cat_prod;
    }

    public String getDesc_prod() {
        return desc_prod;
    }

    public void setDesc_prod(String desc_prod) {
        this.desc_prod = desc_prod;
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
        return "produit{" + "id_prod=" + id_prod + ", nom_prod=" + nom_prod + ", prix_prod=" + prix_prod + ", quant_prod=" + quant_prod + ", img_prod=" + img_prod + ", cat_prod=" + cat_prod + ", desc_prod=" + desc_prod + '}';
    }

    
  
    
    
}
