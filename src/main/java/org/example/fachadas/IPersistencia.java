package org.example.fachadas;

import com.roberto_rw.entidades.*;
import org.example.interfacesDAO.ICitasDAO;

import java.time.LocalDateTime;
import java.util.List;

public interface IPersistencia {
    //Citas
    public void agregarCita(Cita cita);
    public void eliminarCita(Cita cita);
    public void actualizarCita(Cita cita);
    public Cita obtenerCita(Long id);
    public List<Cita> obtenerCitasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    public List<Cita> obtenerCitas();

    //Clientes
    public void agregarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);

    public void actualizarCliente(Cliente cliente);

    public Cliente obtenerCliente(Long id);
    public List<Cliente> obtenerClientes();

    //Empleados
    public void agregarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);

    public void actualizarEmpleado(Empleado empleado);

    public Empleado obtenerEmpleado(Long id);
    public List<Empleado> obtenerEmpleados();

    //Servicios
    public void agregarServicio(Servicio servicio);

    public void eliminarServicio(Servicio servicio);

    public void actualizarServicio(Servicio servicio);

    public Servicio obtenerServicio(Long id);
    public List<Servicio> obtenerServicios();

    //Usuarios
    public void agregarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);

    public void actualizarUsuario(Usuario usuario);

    public Usuario obtenerUsuario(Long id);
    public List<Usuario> obtenerUsuarios();
}