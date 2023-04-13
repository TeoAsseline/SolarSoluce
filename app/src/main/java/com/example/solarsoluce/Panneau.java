package com.example.solarsoluce;

public class Panneau {

    int id;
    String nom;
    String type;
    String description;
    double prodmoy;
    double prodmax;
    double rendement;

    public Panneau(int id, String nom, String type, String description, double prodmoy, double prodmax, double rendement) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prodmoy = prodmoy;
        this.prodmax = prodmax;
        this.rendement = rendement;
    }

    public Panneau(String nom, String type, String description, double prodmoy, double prodmax, double rendement) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prodmoy = prodmoy;
        this.prodmax = prodmax;
        this.rendement = rendement;
    }

    public Panneau() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProdmoy() {
        return prodmoy;
    }

    public void setProdmoy(double prodmoy) {
        this.prodmoy = prodmoy;
    }

    public double getProdmax() {
        return prodmax;
    }

    public void setProdmax(double prodmax) {
        this.prodmax = prodmax;
    }

    public double getRendement() {
        return rendement;
    }

    public void setRendement(double rendement) {
        this.rendement = rendement;
    }
}
