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
    private byte[] imagen;
    private int existencia;

    public Equipo(String nombre, float costoAlquiler, SubFamilia miSubFamilia, byte[] imagen, int existencia) {
        this.nombre = nombre;
        this.costoAlquiler = costoAlquiler;
        this.miSubFamilia = miSubFamilia;
        this.imagen = imagen;
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
}
