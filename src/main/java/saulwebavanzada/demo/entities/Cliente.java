package saulwebavanzada.demo.entities;

import ij.ImagePlus;

public class Cliente {
    private String nombre;
    private String Apellido;
    private String cedula;
    private ImagePlus imagen;

    public Cliente(String nombre, String apellido, String cedula, ImagePlus imagen) {
        this.nombre = nombre;
        Apellido = apellido;
        this.cedula = cedula;
        this.imagen = imagen;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ImagePlus getImagen() {
        return imagen;
    }

    public void setImagen(ImagePlus imagen) {
        this.imagen = imagen;
    }
}
