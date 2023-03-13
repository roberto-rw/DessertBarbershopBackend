package org.example.persistencia;

import com.roberto_rw.entidades.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.conexion.IConexionBD;
import org.example.interfacesDAO.ICitasDAO;

import java.time.LocalDateTime;
import java.util.List;

public class CitasDAO implements ICitasDAO {
    private final IConexionBD conexionBD;
    private final EntityManager em;

    public CitasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.em = this.conexionBD.crearConexion();
    }

    @Override
    public void agregarCita(Cita cita) {
        em.getTransaction().begin();
        Empleado empleado = em.find(Empleado.class, cita.getEmpleado().getId());
        Cliente cliente = em.find(Cliente.class, cita.getCliente().getId());
        Servicio servicio = em.find(Servicio.class, cita.getServicio().getId());
        Usuario usuario = em.find(Usuario.class, cita.getUsuario().getId());

        cita.setEmpleado(empleado);
        cita.setCliente(cliente);
        cita.setServicio(servicio);
        cita.setUsuario(usuario);

        em.persist(cita);

        em.getTransaction().commit();
    }

    @Override
    public void eliminarCita(Cita cita) {
        em.getTransaction().begin();
        em.remove(cita);
        em.getTransaction().commit();
    }

    @Override
    public void actualizarCita(Cita nuevaCita) {
        em.getTransaction().begin();

        Cita cita = em.find(Cita.class, nuevaCita.getId());

        Empleado empleado = em.find(Empleado.class, cita.getEmpleado().getId());
        Cliente cliente = em.find(Cliente.class, cita.getCliente().getId());
        Servicio servicio = em.find(Servicio.class, cita.getServicio().getId());
        Usuario usuario = em.find(Usuario.class, cita.getUsuario().getId());

        cita.setEmpleado(empleado);
        cita.setCliente(cliente);
        cita.setServicio(servicio);
        cita.setUsuario(usuario);

        em.persist(cita);

        em.getTransaction().commit();
    }

    @Override
    public Cita obtenerCita(Long id) {
        em.getTransaction().begin();
        Cita cita = em.find(Cita.class, id);
        em.getTransaction().commit();
        return cita;
    }

    @Override
    public List<Cita> obtenerCitasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        em.getTransaction().begin();
        TypedQuery<Cita> query = em.createQuery(
                "SELECT c FROM Cita c " +
                        "WHERE c.fechaInicio BETWEEN :fechaInicio AND :fechaFin " +
                        "   OR c.fechaFin BETWEEN :fechaInicio AND :fechaFin",
                Cita.class);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        List<Cita> citas = query.getResultList();
        em.getTransaction().commit();
        return citas;
    }

    @Override
    public List<Cita> obtenerCitas() {
        LocalDateTime currentDate = LocalDateTime.now();

        em.getTransaction().begin();
        //Elimina las citas pasadas
        Query deleteQuery = em.createQuery("DELETE FROM Cita c WHERE c.fechaFin < :currentDate");
        deleteQuery.setParameter("currentDate", currentDate);
        deleteQuery.executeUpdate();

        //Consulta todas las citas
        TypedQuery<Cita> selectQuery = em.createQuery("SELECT c FROM Cita c", Cita.class);
        List<Cita> citas = selectQuery.getResultList();

        em.getTransaction().commit();
        return citas;
    }
}