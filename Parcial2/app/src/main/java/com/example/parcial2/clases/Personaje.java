package com.example.parcial2.clases;

public class Personaje {
    private String imagen;
    private String nombre;
    private String programa;

    public Personaje(String imagen, String nombre, String programa) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.programa = programa;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
