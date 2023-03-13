package org.example.interfacesDAO;

import com.roberto_rw.entidades.Empleado;

import java.util.List;

public interface IEmpleadosDAO {
    public void agregarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);

    public void actualizarEmpleado(Empleado empleado);

    public Empleado obtenerEmpleado(Long id);
    public List<Empleado> obtenerEmpleados();
}
