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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    private static EntityManager em = entityManagerFactory.createEntityManager();
    public static void main(String[] args){

        ILogicaNegocio logicaNegocio = new LogicaNegocio();

//        Cita cita = logicaNegocio.obtenerCita(12L);
//        cita.setFechaInicio(LocalDateTime.of(2023,04,22,2,0,0));
//        cita.setFechaFin(LocalDateTime.of(2023,04,22,3,0,0));


//        Cita cita = new Cita();
//        cita.setFechaInicio(LocalDateTime.of(2023,04,22,13,0,0));
//        cita.setFechaFin(LocalDateTime.of(2023,04,22,14,0,0));
//
//        try{
//            logicaNegocio.agregarCita(cita);
//            //logicaNegocio.actualizarCita(cita);
//        }catch(Exception e){
//            e.printStackTrace();
//        }

        em.getTransaction().begin();
        Cita cita = em.find(Cita.class, 45L);
        Empleado empleado = em.find(Empleado.class, 1L);
        cita.setEmpleado(empleado);
        em.persist(cita);
        em.getTransaction().commit();



        //System.out.println(citasBO.seEmpalman(inicio, fin));

//        List<Cita> citasEmpalmadas = logicaNegocio.obtenerCitasPorPeriodo(inicio, fin);

//        for(Cita c: citasEmpalmadas){
//            System.out.println(c);
//        }


    }
}