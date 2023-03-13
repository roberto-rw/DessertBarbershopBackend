package org.example.persistencia;

import com.roberto_rw.entidades.Cita;
import com.roberto_rw.entidades.Cliente;
import jakarta.persistence.EntityManager;
import org.example.conexion.IConexionBD;
import org.example.interfacesDAO.IClientesDAO;

import java.util.List;

public class ClientesDAO implements IClientesDAO {
    private final IConexionBD conexionBD;
    private final EntityManager em;

    public ClientesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.em = this.conexionBD.crearConexion();
    }


    @Override
    public void agregarCliente(Cliente cliente) {

    }

    @Override
    public void eliminarCliente(Cliente cliente) {

    }

    @Override
    public void actualizarCliente(Cliente cliente) {

    }

    @Override
    public Cliente obtenerCliente(Long id) {
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id);
        em.getTransaction().commit();
        return cliente;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return null;
    }
}
