package saulwebavanzada.demo.entities;

public class SubFamilia {
    private String nombre;
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
}
