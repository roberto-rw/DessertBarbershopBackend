package org.example.interfacesDAO;

import com.roberto_rw.entidades.Cliente;

import java.util.List;

public interface IClientesDAO {
    public void agregarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);

    public void actualizarCliente(Cliente cliente);

    public Cliente obtenerCliente(Long id);
    public List<Cliente> obtenerClientes();
}
