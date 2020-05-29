package saulwebavanzada.demo.entities;

import javax.persistence.*;

@Entity
public class CantidadEquipo {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Equipo equipo;
    private int cantidad;

    public CantidadEquipo(){}

    public CantidadEquipo(Equipo equipo, int cantidad){
        this.equipo = equipo;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
