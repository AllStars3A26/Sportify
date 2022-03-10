/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Lenovo
 */
public class Entraineur extends Utilisateur{
    private String type_E,num;
    private int dure;
    private Date  date_contract;
    public Entraineur(){
        
    }
    public Entraineur( String nom, String prenom, String adresse, String login, String pwd,String num,String email,String type_E, int dure, String date_c, int role) {
        super( role, nom, prenom, adresse, login, pwd,email);
        this.type_E = type_E;
        this.dure = dure;
        try{
         
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date udco=df.parse(date_c);
        long ms=udco.getTime();
        java.sql.Date squdco= new java.sql.Date(ms);
        this.date_contract = squdco;
        }catch(ParseException ex) {
            System.out.println(ex.getMessage());
        }
        
        this.num=num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType_E() {
        return type_E;
    }

    public void setType_E(String type_E) {
        this.type_E = type_E;
    }

    public int getDure() {
        return dure;
    }

    public void setDure(int dure1) {
        this.dure = dure1;
    }

    public Date getDate_contract() {
        return date_contract;
    }

    public void setDate_contract(Date date_contract) {
        this.date_contract = date_contract;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + type_E + " | " + num + " | " + dure + " | " + date_contract + " ||";
    }


   
    
}
