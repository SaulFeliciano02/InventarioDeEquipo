package saulwebavanzada.demo.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Factura {
    @Id
    @GeneratedValue
    long id;
    @OneToMany
    private Collection<Equipo> equipos;
    @OneToOne
    private Alquiler alquiler;
    private float montoTotal;

    public Factura(Collection equipos, Alquiler alquiler, float montoTotal) {
        this.equipos = equipos;
        this.alquiler = alquiler;
        this.montoTotal = montoTotal;
    }

    public Factura() {
    }

    public long getId() {
        return id;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public Collection<Equipo> getEquipos() {
        return equipos;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public void setEquipos(Collection<Equipo> equipos) {
        this.equipos = equipos;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
}
