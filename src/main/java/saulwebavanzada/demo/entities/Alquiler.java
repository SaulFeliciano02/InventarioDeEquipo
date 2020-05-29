package saulwebavanzada.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Alquiler {
    @Id
    @GeneratedValue
    long id;
    @OneToMany
    private List<CantidadEquipo> equipos;
    private Date fechaRealizacion;
    private Date fechaEntregaPrometida;
    @ManyToOne
    private Cliente miCliente;
    private Date fechaEntregaReal;

    public Alquiler(List<CantidadEquipo> equipos, Date fechaRealizacion, Date fechaEntregaPrometida, Cliente miCliente) {
        this.equipos = equipos;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaEntregaPrometida = fechaEntregaPrometida;
        this.miCliente = miCliente;
        this.fechaEntregaReal = null;
    }

    public Alquiler() {
    }

    public List<CantidadEquipo> getEquipos() {
        return equipos;
    }

    public void setEquipo(List<CantidadEquipo> equipos) {
        this.equipos = equipos;
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

    public long getId() {
        return id;
    }
}
