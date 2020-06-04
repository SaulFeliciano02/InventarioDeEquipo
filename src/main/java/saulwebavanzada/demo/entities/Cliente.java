package saulwebavanzada.demo.entities;

import ij.ImagePlus;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {
    @Id @GeneratedValue long id;
    @Column(length = 2000)
    private String nombre;
    @Column(length = 2000)
    private String Apellido;
    private String cedula;
    @OneToMany
    private List<Alquiler> alquileres;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] imagen;

    public Cliente(String nombre, String apellido, String cedula, List<Alquiler> alquileres, byte[] imagen) {
        this.nombre = nombre;
        Apellido = apellido;
        this.cedula = cedula;
        this.alquileres = alquileres;
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public long getId() {
        return id;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }
}
