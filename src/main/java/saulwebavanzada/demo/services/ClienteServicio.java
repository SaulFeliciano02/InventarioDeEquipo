package saulwebavanzada.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import saulwebavanzada.demo.entities.Cliente;
import saulwebavanzada.demo.repositories.ClienteRepositorio;

import java.util.List;
import java.util.Optional;

public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> getClientes(){
        return clienteRepositorio.findAll();
    }

    public Cliente getClienteById(long id){
        return clienteRepositorio.findById(id);
    }

    public Cliente getClienteByName(String nombre){
        return clienteRepositorio.findByNombre(nombre);
    }

    public Cliente getClienteByCedula(String cedula){
        return clienteRepositorio.findByCedula(cedula);
    }

    @Transactional
    public boolean crearCliente(Cliente cliente){
        if(clienteRepositorio.findById(cliente.getId()) != null){
            return false;
        }
        clienteRepositorio.save(cliente);
        return true;
    }

    @Transactional
    public boolean eliminarCliente(long id){
        Cliente cliente = clienteRepositorio.findById(id);
        if(cliente != null){
            clienteRepositorio.delete(cliente);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean editarCliente(Cliente cliente){
        Optional<Cliente> e = Optional.ofNullable(clienteRepositorio.findById(cliente.getId()));
        if(e.isPresent()){
            Cliente nuevoCliente = e.get();
            nuevoCliente.setApellido(cliente.getApellido());
            nuevoCliente.setNombre(cliente.getNombre());
            nuevoCliente.setCedula(cliente.getCedula());
            nuevoCliente.setImagen(cliente.getImagen());
            return true;
        }
        return false;
    }

}
