package org.example.fachadas;

import com.roberto_rw.entidades.*;
import org.example.factory.BOFactory;
import org.example.interfacesBO.*;
import org.example.interfacesDAO.IClientesDAO;

import java.time.LocalDateTime;
import java.util.List;

public class LogicaNegocio implements ILogicaNegocio{

    private ICitasBO citasBO;
    private IEmpleadosBO empleadosBO;
    private IClientesBO clientesBO;
    private IServiciosBO serviciosBO;
    private IUsuariosBO usuariosBO;

    public LogicaNegocio(){
        citasBO = BOFactory.crearCitasBO();
        empleadosBO = BOFactory.crearEmpleadosBO();
        clientesBO = BOFactory.crearClientesBO();
        serviciosBO = BOFactory.crearServiciosBO();
        usuariosBO = BOFactory.crearUsuariosBO();
    }

    //Citas
    @Override
    public void agregarCita(Cita cita) {
        citasBO.agregarCita(cita);
    }

    @Override
    public void eliminarCita(Cita cita) {
        citasBO.eliminarCita(cita);
    }

    @Override
    public void actualizarCita(Cita cita) {
        citasBO.actualizarCita(cita);
    }

    @Override
    public Cita obtenerCita(Long id) {
        return citasBO.obtenerCita(id);
    }

    @Override
    public List<Cita> obtenerCitasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return citasBO.obtenerCitasPorPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<Cita> obtenerCitas() {
        return citasBO.obtenerCitas();
    }

    @Override
    public List<Cita> obtenerCitasPorCliente(String nombreCliente) {
        return citasBO.obtenerCitasPorCliente(nombreCliente);
    }

    @Override
    public List<Cita> obtenerCitasPorEmpleado(Empleado empleado) {
        return citasBO.obtenerCitasPorEmpleado(empleado);
    }


    //Clientes
    @Override
    public void agregarCliente(Cliente cliente) {
        clientesBO.agregarCliente(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clientesBO.eliminarCliente(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clientesBO.actualizarCliente(cliente);
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return clientesBO.obtenerCliente(id);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clientesBO.obtenerClientes();
    }


    //Empleados
    @Override
    public void agregarEmpleado(Empleado empleado) {
        empleadosBO.agregarEmpleado(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadosBO.eliminarEmpleado(empleado);
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        empleadosBO.actualizarEmpleado(empleado);
    }

    @Override
    public Empleado obtenerEmpleado(Long id) {
        return empleadosBO.obtenerEmpleado(id);
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return empleadosBO.obtenerEmpleados();
    }

    @Override
    public List<Empleado> obtenerEmpleadosPeluqueros() {
        return empleadosBO.obtenerEmpleadosPeluqueros();
    }


    //Servicios
    @Override
    public void agregarServicio(Servicio servicio) {
        serviciosBO.agregarServicio(servicio);
    }

    @Override
    public void eliminarServicio(Servicio servicio) {
        serviciosBO.eliminarServicio(servicio);
    }

    @Override
    public void actualizarServicio(Servicio servicio) {
        serviciosBO.actualizarServicio(servicio);
    }

    @Override
    public Servicio obtenerServicio(Long id) {
        return serviciosBO.obtenerServicio(id);
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return serviciosBO.obtenerServicios();
    }


    //Usuarios
    @Override
    public void agregarUsuario(Usuario usuario) {
        usuariosBO.agregarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuariosBO.eliminarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuariosBO.actualizarUsuario(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuariosBO.obtenerUsuario(id);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuariosBO.obtenerUsuarios();
    }


}
