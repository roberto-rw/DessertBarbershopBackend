package org.example.interfacesDAO;

import com.roberto_rw.entidades.Cita;
import com.roberto_rw.entidades.Cliente;
import com.roberto_rw.entidades.Empleado;
import com.roberto_rw.entidades.Servicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ICitasDAO {
    public void agregarCita(Cita cita);
    public void eliminarCita(Cita cita);
    public void actualizarCita(Cita cita);
    public Cita obtenerCita(Long id);
    public List<Cita> obtenerCitasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    public List<Cita> obtenerCitasPorPeriodoExcluyendoCita(LocalDateTime fechaInicio, LocalDateTime fechaFin, Long idCita);
    public List<Cita> obtenerCitas();

    public List<Cita> obtenerCitasPorCliente(String nombreCliente);

    public List<Cita> obtenerCitasPorEmpleado(Empleado empleado);

    public List<Cita> obtenerCitasPorEmpleadoClienteFecha(LocalDateTime fecha, Empleado empleado, String cliente);
    List<Cita> obtenerCitasPorServicio(Servicio servicio);

}
