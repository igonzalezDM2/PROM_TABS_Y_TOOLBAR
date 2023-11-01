package com.example.tabsytoolbar;

public class Contacto {
    private int img;
    private String nom, tlf;


    public Contacto(int img, String nom, String tlf) {
        this.img = img;
        this.nom = nom;
        this.tlf = tlf;
    }

    public int getImg() {
        return img;
    }

    public Contacto setImg(int img) {
        this.img = img;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Contacto setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getTlf() {
        return tlf;
    }

    public Contacto setTlf(String tlf) {
        this.tlf = tlf;
        return this;
    }
}
