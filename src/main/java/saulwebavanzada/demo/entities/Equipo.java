package saulwebavanzada.demo.entities;

import ij.ImagePlus;

import javax.persistence.*;

@Entity
public class Equipo {
    @Id @GeneratedValue long id;
    @Column(length = 2000)
    private String nombre;
    private float costoAlquiler;
    @ManyToOne
    private SubFamilia miSubFamilia;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String imagen;
    private String image_properties;
    private int existencia;

    public Equipo(String nombre, float costoAlquiler, SubFamilia miSubFamilia, String imagen, String image_properties, int existencia) {
        this.nombre = nombre;
        this.costoAlquiler = costoAlquiler;
        this.miSubFamilia = miSubFamilia;
        this.imagen = imagen;
        this.image_properties = image_properties;
        this.existencia = existencia;
    }

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCostoAlquiler() {
        return costoAlquiler;
    }

    public void setCostoAlquiler(float costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
    }

    public SubFamilia getMiSubFamilia() {
        return miSubFamilia;
    }

    public void setMiSubFamilia(SubFamilia miSubFamilia) {
        this.miSubFamilia = miSubFamilia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public long getId() {
        return id;
    }

    public String getImage_properties() {
        return image_properties;
    }

    public void setImage_properties(String image_properties) {
        this.image_properties = image_properties;
    }
}
