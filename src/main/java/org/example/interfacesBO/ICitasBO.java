package org.example.interfacesBO;

import com.roberto_rw.entidades.Cita;
import com.roberto_rw.entidades.Empleado;
import com.roberto_rw.entidades.Cliente;

import java.time.LocalDateTime;
import java.util.List;

public interface ICitasBO {
    public void agregarCita(Cita cita) throws Exception;
    public void eliminarCita(Cita cita);
    public void actualizarCita(Cita cita) throws Exception;
    public Cita obtenerCita(Long id);
    public List<Cita> obtenerCitasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    public List<Cita> obtenerCitas();

    public List<Cita> obtenerCitasPorCliente(String nombreCliente);

    public List<Cita> obtenerCitasPorEmpleado(Empleado empleado);

    public List<Cita> obtenerCitasPorEmpleadoClienteFecha(LocalDateTime fecha, Empleado empleado, String cliente);
}
