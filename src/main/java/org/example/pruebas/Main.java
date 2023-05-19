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
import java.time.LocalTime;
import java.util.List;

public class Main {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    private static EntityManager em = entityManagerFactory.createEntityManager();
    public static void main(String[] args){

        ILogicaNegocio logicaNegocio = new LogicaNegocio();

//        Empleado nuevoEmpleado = new Empleado();
//        LocalTime horaEntrada = LocalTime.of(10,0);
//        LocalTime horaSalida = LocalTime.of(20,0);
//
//        nuevoEmpleado.setTelefono("324242");
//        nuevoEmpleado.setSalario(50.0);
//        nuevoEmpleado.setPuesto("Developer");
//        nuevoEmpleado.setNombre("Roger 2");
//        nuevoEmpleado.setApellido("Gold");
//        nuevoEmpleado.setHoraEntrada(horaEntrada);
//        nuevoEmpleado.setHoraSalida(horaSalida);
//
//
//        try{
//            logicaNegocio.agregarEmpleado(nuevoEmpleado);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        Cliente cliente = logicaNegocio.obtenerCliente(1L);
////        logicaNegocio.eliminarCliente(cliente);

//        Empleado empleado = logicaNegocio.obtenerEmpleado(1L);
//        logicaNegocio.eliminarEmpleado(empleado);

//        Servicio servicio = logicaNegocio.obtenerServicio(1L);
//        logicaNegocio.eliminarServicio(servicio);

    }
}