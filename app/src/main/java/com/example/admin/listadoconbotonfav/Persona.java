package com.example.admin.listadoconbotonfav;

/**
 * Created by admin on 08/01/2018.
 */

public class Persona {
    String nombre;
    String telefono;
    int id;

    public Persona(String nombre, String telefono,int id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = id;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }
}
