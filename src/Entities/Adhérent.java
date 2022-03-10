/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;



/**
 *
 * @author Lenovo
 */
public class Adhérent extends Utilisateur{
    private String desc;
    private Date date_inscrit;
    private String image;
    
    public Adhérent(){
        
    }
    public Adhérent( String nom, String prenom, String adresse, String login, String pwd,int role, String image,String email,String desc) {
        super( role, nom, prenom, adresse, login, pwd, email);
        this.desc = desc;
       // this.date_inscrit = date;
        this.image=image;
    }
    public Adhérent(String nom, String prenom, String adresse, String login, String pwd,int role,String email,String desc){
         super( role, nom, prenom, adresse, login, pwd, email);
        this.desc = desc;
       // this.date_inscrit = date;
       // this.image=image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate_inscrit() {
        return date_inscrit;
    }

    public void setDate_inscrit(Date date_inscrit) {
        this.date_inscrit = date_inscrit;
    }

    @Override
    public String toString() {
        return super.toString()+"=Adhérent avec{" + "desc=" + desc + ", date_inscrit=" + date_inscrit + ", image=" + image + '}';
    }

    
    
}
