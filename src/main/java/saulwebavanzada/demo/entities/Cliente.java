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
    private String image_properties;
    @OneToMany
    private List<Alquiler> alquileres;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = true)
    private String imagen;

    public Cliente(String nombre, String apellido, String cedula, List<Alquiler> alquileres, String imagen, String image_properties) {
        this.nombre = nombre;
        Apellido = apellido;
        this.cedula = cedula;
        this.alquileres = alquileres;
        this.imagen = imagen;
        this.image_properties = image_properties;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
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

    public void setId(long id) {
        this.id = id;
    }

    public String getImage_properties() {
        return image_properties;
    }

    public void setImage_properties(String image_properties) {
        this.image_properties = image_properties;
    }
}
