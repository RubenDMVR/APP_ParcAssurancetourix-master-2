package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

public class User {


    private String email, mdp, droits ;
    private int id_personne;


    public User(int id_personne,String email, String mdp, String droits ) {
        this.id_personne = id_personne;
        this.email = email;
        this.mdp = mdp;
        this.droits = droits;


    }

    public User(String email, String mdp, String droits) {

        this.id_personne = 0;
        this.email = email;
        this.mdp = mdp;
        this.droits = droits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getDroits() {
        return droits;
    }

    public void setDroits(String droits) {
        this.droits = droits;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }
}
