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
public class Commande {
    private int id_com;
    private String date_com;
    private float prix_com;
    private int quant_com;

    public Commande()
    {}
    public Commande(int id_com, String date_com, float prix_com, int quant_com) {
        this.id_com = id_com;
        this.date_com = date_com;
        this.prix_com = prix_com;
        this.quant_com = quant_com;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public String getDate_com() {
        return date_com;
    }

    public void setDate_com(String date_com) {
        this.date_com = date_com;
    }

    public float getPrix_com() {
        return prix_com;
    }

    public void setPrix_com(float prix_com) {
        this.prix_com = prix_com;
    }

    public int getQuant_com() {
        return quant_com;
    }

    public void setQuant_com(int quant_com) {
        this.quant_com = quant_com;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_com=" + id_com + ", date_com=" + date_com + ", prix_com=" + prix_com + ", quant_com=" + quant_com + '}';
    }
    
   

    
    
}
