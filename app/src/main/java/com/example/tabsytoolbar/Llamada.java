package com.example.tabsytoolbar;

import java.util.Date;

public class Llamada {
    private Contacto contacto;
    private Date hora;
    private int duracion;

    public Llamada(Contacto contacto, Date hora, int duracion) {
        this.contacto = contacto;
        this.hora = hora;
        this.duracion = duracion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public Llamada setContacto(Contacto contacto) {
        this.contacto = contacto;
        return this;
    }

    public Date getHora() {
        return hora;
    }

    public Llamada setHora(Date hora) {
        this.hora = hora;
        return this;
    }

    public int getDuracion() {
        return duracion;
    }

    public Llamada setDuracion(int duracion) {
        this.duracion = duracion;
        return this;
    }
}
