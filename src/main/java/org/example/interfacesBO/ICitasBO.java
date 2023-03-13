package org.example.interfacesBO;

import com.roberto_rw.entidades.Cita;

import java.time.LocalDateTime;
import java.util.List;

public interface ICitasBO {
    public void agregarCita(Cita cita);
    public void eliminarCita(Cita cita);
    public void actualizarCita(Cita cita);
    public Cita obtenerCita(Long id);
    public List<Cita> obtenerCitasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    public List<Cita> obtenerCitas();
}
