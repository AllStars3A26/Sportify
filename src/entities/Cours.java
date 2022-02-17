/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Lenovo
 */
public class Cours {
    private int id;
    private String type , imc ,titre , nomE;

    public Cours ()
    {
        
    }
    public Cours(int id, String titre, String nome, String type, String imc) {
        this.id = id;
        this.type = type;
        this.imc = imc;
        this.titre = titre;
        this.nomE = nome;
    }
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
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
        return "Cours{" + "id=" + id + ", description du cour=" + type + ", impact physique =" + imc + ", titre=" + titre + ", nom_entreineur=" + nomE + '}';
    }
    
}
