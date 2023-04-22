package org.example.pruebas;

import com.roberto_rw.entidades.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.fachadas.ILogicaNegocio;
import org.example.fachadas.LogicaNegocio;
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

        ILogicaNegocio logicaNegocio = new LogicaNegocio();

        Cita cita = logicaNegocio.obtenerCita(12L);
        cita.setEmpleado(logicaNegocio.obtenerEmpleado(1L));


//        List<Cita> citas = persistencia.obtenerCitas();
//
//        for (Cita c: citas){
//            System.out.println(c.getCliente().getNombre() + " " + c.getFechaFin());
//        }
//        persistencia.agregarCita(cita);



    }
}