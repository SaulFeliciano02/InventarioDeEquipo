package saulwebavanzada.demo.entities;

import javax.persistence.*;

@Entity
public class SubFamilia {
    @Id
    @GeneratedValue
    long id;
    @Column(length = 2000)
    private String nombre;
    @ManyToOne
    private Familia miFamilia;

    public SubFamilia(String nombre, Familia miFamilia) {
        this.nombre = nombre;
        this.miFamilia = miFamilia;
    }

    public SubFamilia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Familia getMiFamilia() {
        return miFamilia;
    }

    public void setMiFamilia(Familia miFamilia) {
        this.miFamilia = miFamilia;
    }

    public long getId() {
        return id;
    }
}
