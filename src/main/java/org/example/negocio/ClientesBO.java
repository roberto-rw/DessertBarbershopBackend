package org.example.negocio;

import com.roberto_rw.entidades.Cita;
import com.roberto_rw.entidades.Cliente;
import org.example.fachadas.IPersistencia;
import org.example.fachadas.Persistencia;
import org.example.interfacesBO.IClientesBO;

import java.util.List;

public class ClientesBO implements IClientesBO {
    private IPersistencia persistencia = new Persistencia();
    public ClientesBO(){}
    @Override
    public void agregarCliente(Cliente cliente) {
        persistencia.agregarCliente(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente){
        List<Cita> citasCliente = persistencia.obtenerCitasPorCliente(cliente.getNombre());
        if(!citasCliente.isEmpty()) throw new RuntimeException("No se puede eliminar un cliente con citas agendadas");
        persistencia.eliminarCliente(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        persistencia.actualizarCliente(cliente);
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return persistencia.obtenerCliente(id);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return persistencia.obtenerClientes();
    }
}
