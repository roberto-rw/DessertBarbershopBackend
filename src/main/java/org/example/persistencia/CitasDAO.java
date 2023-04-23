package org.example.persistencia;

import com.roberto_rw.entidades.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.conexion.IConexionBD;
import org.example.interfacesDAO.ICitasDAO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
        LocalDateTime fechaInicio = nuevaCita.getFechaInicio();
        LocalDateTime fechaFin = nuevaCita.getFechaFin();

        cita.setEmpleado(empleado);
        cita.setCliente(cliente);
        cita.setServicio(servicio);
        cita.setUsuario(usuario);
        cita.setFechaInicio(fechaInicio);
        cita.setFechaFin(fechaFin);

        em.persist(cita);

        em.getTransaction().commit();
    }

    @Override
    public Cita obtenerCita(Long id) {
        em.getTransaction().begin();
        Cita cita = em.find(Cita.class, id);
        em.getTransaction().commit();
        em.clear();
        return cita;
    }

    @Override
    public List<Cita> obtenerCitasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        em.getTransaction().begin();
        TypedQuery<Cita> query;
        query = em.createQuery(
                "SELECT c FROM Cita c " +
                        "WHERE (c.fechaInicio >= :fechaInicio AND c.fechaInicio < :fechaFin) " +
                        "   OR (c.fechaFin > :fechaInicio AND c.fechaFin <= :fechaFin) " +
                        "   OR (c.fechaInicio <= :fechaInicio AND c.fechaFin >= :fechaFin)",
                Cita.class);

        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);

        List<Cita> citas = query.getResultList();

        em.getTransaction().commit();
        List<Cita> citasSuperpuestas = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getFechaInicio().isBefore(fechaFin) && cita.getFechaFin().isAfter(fechaInicio)) {
                citasSuperpuestas.add(cita);
            }
        }
        return citasSuperpuestas;
    }

    @Override
    public List<Cita> obtenerCitasPorPeriodoExcluyendoCita(LocalDateTime fechaInicio, LocalDateTime fechaFin, Long idCita) {
        em.getTransaction().begin();
        TypedQuery<Cita> query;
        query = em.createQuery(
                "SELECT c FROM Cita c " +
                        "WHERE ((c.fechaInicio >= :fechaInicio AND c.fechaInicio < :fechaFin) " +
                        "       OR (c.fechaFin > :fechaInicio AND c.fechaFin <= :fechaFin) " +
                        "       OR (c.fechaInicio <= :fechaInicio AND c.fechaFin >= :fechaFin)) " +
                        "       AND c.id != :idCita",
                Cita.class);

        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        query.setParameter("idCita", idCita);

        List<Cita> citas = query.getResultList();

        em.getTransaction().commit();
        List<Cita> citasSuperpuestas = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getFechaInicio().isBefore(fechaFin) && cita.getFechaFin().isAfter(fechaInicio)) {
                citasSuperpuestas.add(cita);
            }
        }
        return citasSuperpuestas;
    }

    @Override
    public List<Cita> obtenerCitas() {
        LocalDateTime currentDate = LocalDateTime.now();

        em.getTransaction().begin();
        //Elimina las citas pasadas
        //Query deleteQuery = em.createQuery("DELETE FROM Cita c WHERE c.fechaFin < :currentDate");
        //deleteQuery.setParameter("currentDate", currentDate);
        //deleteQuery.executeUpdate();

        //Consulta todas las citas
        TypedQuery<Cita> selectQuery = em.createQuery("SELECT c FROM Cita c", Cita.class);
        List<Cita> citas = selectQuery.getResultList();

        em.getTransaction().commit();
        return citas;
    }

    @Override
    public List<Cita> obtenerCitasPorCliente(String nombreCliente) {
        TypedQuery<Cita> query = em.createQuery("SELECT c FROM Cita c JOIN c.cliente cli WHERE cli.nombre LIKE :nombreCliente", Cita.class);
        query.setParameter("nombreCliente", "%"+nombreCliente+"%");
        List<Cita> citas = query.getResultList();
        return citas;
    }

    @Override
    public List<Cita> obtenerCitasPorEmpleado(Empleado empleado) {
        TypedQuery<Cita> query = em.createQuery("SELECT c FROM Cita c WHERE c.empleado = :idEmpleado", Cita.class);
        query.setParameter("idEmpleado", empleado);
        List<Cita> citas = query.getResultList();

        return citas;
    }

    @Override
    public List<Cita> obtenerCitasPorEmpleadoClienteFecha(LocalDateTime fecha, Empleado empleado, String cliente){
        String query = "SELECT c FROM Cita c";


        if(cliente != null){
            query += " JOIN c.cliente cl WHERE cl.nombre LIKE :nombre";
            query += " AND c.fechaInicio BETWEEN :inicio AND :fin";
        } else{
            query += " WHERE c.fechaInicio BETWEEN :inicio AND :fin";
        }

        if(empleado != null){
            query += " AND c.empleado = :empleado";
        }

        TypedQuery<Cita> tquery = em.createQuery(query, Cita.class);

        tquery.setParameter("inicio", fecha.with(LocalTime.MIN));
        tquery.setParameter("fin", fecha.with(LocalTime.MAX));

        if(cliente != null){
            tquery.setParameter("nombre", "%"+cliente+"%");
        }
        if(empleado != null){
            tquery.setParameter("empleado", empleado);
        }

        List<Cita> citas = tquery.getResultList();

        return citas;

    }

}
