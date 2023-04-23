package org.example.negocio;

import com.roberto_rw.entidades.Cita;
import com.roberto_rw.entidades.Empleado;
import org.example.fachadas.IPersistencia;
import org.example.fachadas.Persistencia;
import org.example.factory.DAOFactory;
import org.example.interfacesBO.ICitasBO;
import org.example.persistencia.CitasDAO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class CitasBO implements ICitasBO {
    private IPersistencia persistencia = new Persistencia();
    public CitasBO(){}

    @Override
    public void agregarCita(Cita cita) throws Exception {
        if(seEmpalman(cita)){
            throw new Exception("Las fechas se empalman");
        }
        if(!validarHorarioLaboral(cita)){
            throw new Exception("La cita está fuera del horario laboral del peluquero");
        }
        persistencia.agregarCita(cita);
    }

    @Override
    public void eliminarCita(Cita cita) {
        persistencia.eliminarCita(cita);
    }

    @Override
    public void actualizarCita(Cita cita) throws Exception{
        if(seEmpalmanActualizar(cita)){
            throw new Exception("Las Fechas se empalman");
        }
        if(!validarHorarioLaboral(cita)){
            throw new Exception("La cita está fuera del horario laboral del peluquero");
        }
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

    @Override
    public List<Cita> obtenerCitasPorCliente(String nombreCliente) {
        return persistencia.obtenerCitasPorCliente(nombreCliente);
    }

    @Override
    public List<Cita> obtenerCitasPorEmpleado(Empleado empleado) {
        return persistencia.obtenerCitasPorEmpleado(empleado);
    }

    public boolean seEmpalman(Cita cita){
        List<Cita> citasEmpalmadas = persistencia.obtenerCitasPorPeriodo(cita.getFechaInicio(), cita.getFechaFin());
        if(citasEmpalmadas.isEmpty()){
            return false;
        }else{
            for(Cita c: citasEmpalmadas){
                if(c.getCliente().equals(cita.getCliente())) return true;
                if(c.getEmpleado().equals(cita.getEmpleado())) return true;
            }
        }
        return false;
    }

    public boolean seEmpalmanActualizar(Cita cita){
        List<Cita> citasEmpalmadas = persistencia.obtenerCitasPorPeriodoExcluyendoCita(cita.getFechaInicio(), cita.getFechaFin(), cita.getId());
        if(citasEmpalmadas.isEmpty()) {
            return false;
        }else{
            for(Cita c: citasEmpalmadas){
                if(c.getCliente().equals(cita.getCliente())) return true;
                if(c.getEmpleado().equals(cita.getEmpleado())) return true;
            }
        }
        return false;
    }

    public List<Cita> obtenerCitasPorEmpleadoClienteFecha(LocalDateTime fecha, Empleado empleado, String cliente){
        return persistencia.obtenerCitasPorEmpleadoClienteFecha(fecha, empleado, cliente);
    }

    public boolean validarHorarioLaboral(Cita cita){
        Empleado peluquero = persistencia.obtenerEmpleado(cita.getEmpleado().getId());
        LocalTime horaEntrada = peluquero.getHoraEntrada();
        LocalTime horaSalida = peluquero.getHoraSalida();

        LocalTime horaInicio = cita.getFechaInicio().toLocalTime();
        LocalTime horaFin = cita.getFechaFin().toLocalTime();

        // Verificar si la hora de inicio está después o igual que la hora de entrada
        // y si la hora de fin está antes o igual que la hora de salida
        if (horaInicio.isAfter(horaEntrada) || horaInicio.equals(horaEntrada)) {
            if (horaFin.isBefore(horaSalida) || horaFin.equals(horaSalida)) {
                return true; // La cita está dentro del horario laboral
            }
        }
        return false; // La cita está fuera del horario laboral
    }
}
