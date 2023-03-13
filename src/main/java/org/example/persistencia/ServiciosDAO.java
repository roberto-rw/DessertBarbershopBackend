package org.example.persistencia;

import com.roberto_rw.entidades.Empleado;
import com.roberto_rw.entidades.Servicio;
import jakarta.persistence.EntityManager;
import org.example.conexion.IConexionBD;
import org.example.interfacesDAO.IServiciosDAO;

import java.util.List;

public class ServiciosDAO implements IServiciosDAO {
    private final IConexionBD conexionBD;
    private final EntityManager em;

    public ServiciosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.em = this.conexionBD.crearConexion();
    }


    @Override
    public void agregarServicio(Servicio servicio) {

    }

    @Override
    public void eliminarServicio(Servicio servicio) {

    }

    @Override
    public void actualizarServicio(Servicio servicio) {

    }

    @Override
    public Servicio obtenerServicio(Long id) {
        em.getTransaction().begin();
        Servicio servicio = em.find(Servicio.class, id);
        em.getTransaction().commit();
        return servicio;
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return null;
    }
}