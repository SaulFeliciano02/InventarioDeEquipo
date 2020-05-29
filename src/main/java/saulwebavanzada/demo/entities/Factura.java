package saulwebavanzada.demo.entities;

import java.util.ArrayList;

public class Factura {
    private ArrayList<Alquiler> misAlquileres;
    private float montoTotal;

    public Factura(ArrayList<Alquiler> misAlquileres, float montoTotal) {
        this.misAlquileres = misAlquileres;
        this.montoTotal = montoTotal;
    }

    public Factura() {
    }

    public ArrayList<Alquiler> getMisAlquileres() {
        return misAlquileres;
    }

    public void setMisAlquileres(ArrayList<Alquiler> misAlquileres) {
        this.misAlquileres = misAlquileres;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
}
