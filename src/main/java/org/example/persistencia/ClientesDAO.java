package org.example.persistencia;

import com.roberto_rw.entidades.Cita;
import com.roberto_rw.entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        em.getTransaction().begin();
        Cliente nuevoCliente = em.find(Cliente.class, cliente.getId());
        nuevoCliente.setNombre(cliente.getNombre());
        nuevoCliente.setCorreo(cliente.getCorreo());
        nuevoCliente.setTelefono(cliente.getTelefono());
        em.persist(nuevoCliente);
        em.getTransaction().commit();
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
        em.getTransaction().begin();
        TypedQuery<Cliente> selectQuery = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> clientes = selectQuery.getResultList();
        em.getTransaction().commit();
        return clientes;
    }


}
