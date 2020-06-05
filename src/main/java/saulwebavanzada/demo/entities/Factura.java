package saulwebavanzada.demo.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Factura {
    @Id
    @GeneratedValue
    long id;
    @OneToOne
    private Equipo equipo;
    @OneToOne
    private Alquiler alquiler;
    private float montoTotal;

    public Factura(Equipo equipo, Alquiler alquiler, float montoTotal) {
        this.equipo = equipo;
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
}
