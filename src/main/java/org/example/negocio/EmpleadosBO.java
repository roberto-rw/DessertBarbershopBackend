package org.example.negocio;

import com.roberto_rw.entidades.Cita;
import com.roberto_rw.entidades.Empleado;
import org.example.fachadas.IPersistencia;
import org.example.fachadas.Persistencia;
import org.example.interfacesBO.IEmpleadosBO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EmpleadosBO implements IEmpleadosBO {
    private IPersistencia persistencia = new Persistencia();
    private final LocalTime HORA_ENTRADA = LocalTime.of(10,0);
    private final LocalTime HORA_CIERRE = LocalTime.of(20,0);
    @Override
    public void agregarEmpleado(Empleado empleado) {
        validarHorarioLaboral(empleado);
        persistencia.agregarEmpleado(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        List<Cita> citasEmpleado = persistencia.obtenerCitasPorEmpleado(empleado);
        if(!citasEmpleado.isEmpty()) throw new RuntimeException("No se puede eliminar un empleado con citas agendadas");
        persistencia.eliminarEmpleado(empleado);
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        validarHorarioLaboral(empleado);
        persistencia.actualizarEmpleado(empleado);
    }

    @Override
    public Empleado obtenerEmpleado(Long id) {
        return persistencia.obtenerEmpleado(id);
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return persistencia.obtenerEmpleados();
    }

    @Override
    public List<Empleado> obtenerEmpleadosPeluqueros() {
        return persistencia.obtenerEmpleadosPeluqueros();
    }

    private void validarHorarioLaboral(Empleado empleado){
        LocalTime horaEntradaEmpleado = empleado.getHoraEntrada();
        LocalTime horaSalidaEmpleado = empleado.getHoraSalida();

        // Validar que la hora de entrada no sea mayor que la hora de salida
        if (horaEntradaEmpleado.isAfter(horaSalidaEmpleado)) {
            // La hora de entrada es mayor que la hora de salida del empleado
            throw new RuntimeException("No se puede agregar un empleado con una hora de entrada mayor a la de salida");
        }

        // Comparar con el horario laboral de la empresa
        if (horaEntradaEmpleado.isBefore(HORA_ENTRADA) || horaSalidaEmpleado.isAfter(HORA_CIERRE)) {
            // El horario del empleado está fuera del horario laboral de la empresa
            throw new RuntimeException("No se puede agregar un empleado con horario que este fuera del horario laboral");
        }
    }
}
