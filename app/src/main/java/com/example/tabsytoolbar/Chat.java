package com.example.tabsytoolbar;

import java.util.Date;

public class Chat {
    private Contacto contacto;
    private String ultMensaje;
    private Date hora;

    public Chat(Contacto contacto, String ultMensaje, Date hora) {
        this.contacto = contacto;
        this.ultMensaje = ultMensaje;
        this.hora = hora;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public Chat setContacto(Contacto contacto) {
        this.contacto = contacto;
        return this;
    }

    public String getUltMensaje() {
        return ultMensaje;
    }

    public Chat setUltMensaje(String ultMensaje) {
        this.ultMensaje = ultMensaje;
        return this;
    }

    public Date getHora() {
        return hora;
    }

    public Chat setHora(Date hora) {
        this.hora = hora;
        return this;
    }
}
