package saulwebavanzada.demo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Alquiler {
    @Id
    @GeneratedValue
    long id;
    @OneToOne
    private Equipo equipo;
    private Date fechaRealizacion;
    private Date fechaEntregaPrometida;
    @ManyToOne
    private Cliente miCliente;
    private Date fechaEntregaReal;

    public Alquiler(Equipo equipo, Date fechaRealizacion, Date fechaEntregaPrometida, Cliente miCliente) {
        this.equipo = equipo;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaEntregaPrometida = fechaEntregaPrometida;
        this.miCliente = miCliente;
        this.fechaEntregaReal = null;
    }

    public Alquiler() {
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Date getFechaEntregaPrometida() {
        return fechaEntregaPrometida;
    }

    public void setFechaEntregaPrometida(Date fechaEntregaPrometida) {
        this.fechaEntregaPrometida = fechaEntregaPrometida;
    }

    public Cliente getMiCliente() {
        return miCliente;
    }

    public void setMiCliente(Cliente miCliente) {
        this.miCliente = miCliente;
    }

    public Date getFechaEntregaReal() {
        return fechaEntregaReal;
    }

    public void setFechaEntregaReal(Date fechaEntregaReal) {
        this.fechaEntregaReal = fechaEntregaReal;
    }
}
