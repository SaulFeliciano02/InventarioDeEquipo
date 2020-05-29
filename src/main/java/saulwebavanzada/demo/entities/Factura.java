package saulwebavanzada.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Factura {
    @Id
    @GeneratedValue
    long id;
    @OneToMany
    private Collection<Alquiler> misAlquileres;
    private float montoTotal;

    public Factura(Collection misAlquileres, float montoTotal) {
        this.misAlquileres = misAlquileres;
        this.montoTotal = montoTotal;
    }

    public Factura() {
    }

    public Collection<Alquiler> getMisAlquileres() {
        return misAlquileres;
    }

    public void setMisAlquileres(Collection<Alquiler> misAlquileres) {
        this.misAlquileres = misAlquileres;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
}
