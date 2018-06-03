package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;


public class Parcours
{
    private int id_parcour, id_attraction, id_restaurant, id_personne  ;
    private String libelle ,emailpersonne, mdp, droits, duree, nom_attraction, nom_restaurant ;

    public Parcours(int id_parcour, int id_attraction, int id_restaurant, int id_personne/*,String emailpersonne*/, String libelle, String duree )
    {
        this.id_parcour = id_parcour;
        this.id_attraction = id_attraction;
        this.id_restaurant = id_restaurant;
        this.id_personne = id_personne;
        //this.emailpersonne = emailpersonne;
        this.libelle = libelle;
        this.duree = duree;


    }


    public Parcours(String libelle,String duree, String nom_attraction, String nom_restaurant )
    {
        this.libelle = libelle;
        this.duree = duree;
        this.nom_attraction = nom_attraction;
        this.nom_restaurant = nom_restaurant;


    }



    public Parcours(String libelle, String duree /*,String emailpersonne*/ )
    {
        this.id_parcour = 0;
        this.id_attraction = 0;
        this.id_restaurant = 0;
        this.id_personne = 0;
        //this.emailpersonne = emailpersonne;
        this.libelle = libelle;
        this.duree = duree;

    }

    public String toString()
    {
        return "ID :                  " + this.id_parcour
                + "\nID :             " + this.id_attraction
                + "\nID :             " + this.id_restaurant
                + "\nID :             " + this.id_personne
                + "\nDuree :          " + this.duree;
    }
}
