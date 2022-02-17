/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author snowy
 */

public class Produit {
    private int id_prod;
    private String nom_prod;
    private float prix_prod;
    private String cat_prod,desc_prod;
   public Produit()
    {}
    public Produit(int id_prod, String nom_prod, float prix_prod, String cat_prod, String desc_prod) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.prix_prod = prix_prod;
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

    @Override
    public String toString() {
        return "Produit{" + "id_prod=" + id_prod + ", nom_prod=" + nom_prod + ", prix_prod=" + prix_prod + ", cat_prod=" + cat_prod + ", desc_prod=" + desc_prod + '}';
    }
    
    

    
    
    
}
