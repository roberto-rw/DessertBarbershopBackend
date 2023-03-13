package org.example.negocio;

import com.roberto_rw.entidades.Cita;
import org.example.fachadas.IPersistencia;
import org.example.fachadas.Persistencia;
import org.example.factory.DAOFactory;
import org.example.interfacesBO.ICitasBO;
import org.example.persistencia.CitasDAO;

import java.time.LocalDateTime;
import java.util.List;

public class CitasBO implements ICitasBO {
    private IPersistencia persistencia = new Persistencia();
    public CitasBO(){}

    @Override
    public void agregarCita(Cita cita) {
        if(seEmpalman(cita.getFechaInicio(), cita.getFechaFin())){
            System.out.println("Se empalma la cita");
            return;
        }
        persistencia.agregarCita(cita);
    }

    @Override
    public void eliminarCita(Cita cita) {
        persistencia.eliminarCita(cita);
    }

    @Override
    public void actualizarCita(Cita cita) {
        persistencia.actualizarCita(cita);
    }

    @Override
    public Cita obtenerCita(Long id) {
        return persistencia.obtenerCita(id);
    }

    @Override
    public List<Cita> obtenerCitasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return persistencia.obtenerCitasPorPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<Cita> obtenerCitas() {
        return persistencia.obtenerCitas();
    }

    public boolean seEmpalman(LocalDateTime fechaInicio, LocalDateTime fechaFin){
        List<Cita> citasEmpalmadas = persistencia.obtenerCitasPorPeriodo(fechaInicio, fechaFin);
        if(citasEmpalmadas.isEmpty()) return false;
        return true;
    }
}
