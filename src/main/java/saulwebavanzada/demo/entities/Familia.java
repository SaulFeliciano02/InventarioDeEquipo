package saulwebavanzada.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Familia {
    @Id
    @GeneratedValue
    long id;
    @Column(length = 2000)
    private String nombre;

    public Familia(String nombre) {
        this.nombre = nombre;
    }

    public Familia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
