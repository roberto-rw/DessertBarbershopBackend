package org.example.negocio;

import com.roberto_rw.entidades.Empleado;
import org.example.fachadas.IPersistencia;
import org.example.fachadas.Persistencia;
import org.example.interfacesBO.IEmpleadosBO;

import java.util.List;

public class EmpleadosBO implements IEmpleadosBO {
    private IPersistencia persistencia = new Persistencia();
    @Override
    public void agregarEmpleado(Empleado empleado) {
        persistencia.agregarEmpleado(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        persistencia.eliminarEmpleado(empleado);
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
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
}
