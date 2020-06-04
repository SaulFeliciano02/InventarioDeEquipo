package saulwebavanzada.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import saulwebavanzada.demo.entities.Alquiler;
import saulwebavanzada.demo.entities.Factura;
import saulwebavanzada.demo.repositories.FacturaRepositorio;

import java.util.Optional;

public class FacturaServicio {
    @Autowired
    public FacturaRepositorio facturaRepositorio;

    @Transactional
    public boolean crearFactura(Factura factura){
        if(facturaRepositorio.findById(factura.getId()) != null){
            return false;
        }
        facturaRepositorio.save(factura);
        return true;
    }

    @Transactional
    public boolean eliminarFactura(long id){
        Factura factura = facturaRepositorio.findById(id);
        if(factura != null){
            facturaRepositorio.delete(factura);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean editarFactura(Factura factura){
        Optional<Factura> e = Optional.ofNullable(facturaRepositorio.findById(factura.getId()));
        if(e.isPresent()){
            Factura nuevaFactura = e.get();
            nuevaFactura.setAlquiler(factura.getAlquiler());
            nuevaFactura.setEquipo(factura.getEquipo());
            nuevaFactura.setMontoTotal(factura.getMontoTotal());
            return true;
        }
        return false;
    }
}
