package org.example.pruebas;

import com.roberto_rw.entidades.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.fachadas.Persistencia;
import org.example.factory.DAOFactory;
import org.example.negocio.CitasBO;
import org.example.persistencia.CitasDAO;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    private static EntityManager em = entityManagerFactory.createEntityManager();
    public static void main(String[] args) {

        em.getTransaction().begin();

        Cita cita = new Cita();
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        Empleado empleado = new Empleado();
        empleado.setId(1L);

        Servicio servicio = new Servicio();
        servicio.setId(1L);

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        cita.setCliente(cliente);
        cita.setEmpleado(empleado);
        cita.setServicio(servicio);
        cita.setUsuario(usuario);
        cita.setFechaInicio(LocalDateTime.of(2023, 3, 12, 17, 21, 0, 0));
        cita.setFechaFin(LocalDateTime.of(2023, 3, 12, 20, 0, 0, 0));

        Persistencia persistencia = new Persistencia();
        CitasBO  citasBO = new CitasBO();
//        List<Cita> citas = persistencia.obtenerCitas();
//
//        for (Cita c: citas){
//            System.out.println(c.getCliente().getNombre() + " " + c.getFechaFin());
//        }
//        persistencia.agregarCita(cita);

        citasBO.agregarCita(cita);

        em.getTransaction().commit();

    }
}