/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Fayechi
 */
public class User {
    private int id_user,role;
    private String nom_user,prenom_user,adresse_user,login_user,password_user;
    
    
    	

    public User() {
    }

    public User(String nom_user, String prenom_user, String adresse_user, String login_user, String password_user) {
        
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.adresse_user = adresse_user;
        this.login_user = login_user;
        this.password_user = password_user;
    }

 

    public int getId_user() {
        return id_user;
    }

    public int getRole() {
        return role;
    }

    public String getNom_user() {
        return nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public String getAdresse_user() {
        return adresse_user;
    }

    public String getLogin_user() {
        return login_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public void setAdresse_user(String adresse_user) {
        this.adresse_user = adresse_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    @Override
    public String toString() {
        return "user{" + "id_user=" + id_user + ", role=" + role + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", adresse_user=" + adresse_user + ", login_user=" + login_user + ", password_user=" + password_user + '}';
    }

  
    
}
