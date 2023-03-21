package org.example.interfacesBO;

import com.roberto_rw.entidades.Cliente;
import com.roberto_rw.entidades.Empleado;

import java.util.List;

public interface IClientesBO {
    public void agregarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);

    public void actualizarCliente(Cliente cliente);

    public Cliente obtenerCliente(Long id);
    public List<Cliente> obtenerClientes();
}
