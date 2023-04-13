package org.example.fachadas;

import com.roberto_rw.entidades.*;
import org.example.factory.DAOFactory;
import org.example.interfacesDAO.*;

import java.time.LocalDateTime;
import java.util.List;

public class Persistencia implements IPersistencia{

    private IClientesDAO clientesDAO;
    private ICitasDAO citasDAO;
    private IEmpleadosDAO empleadosDAO;
    private IServiciosDAO serviciosDAO;
    private IUsuariosDAO usuariosDAO;

    public Persistencia(){
        clientesDAO = DAOFactory.crearClientesDAO();
        citasDAO = DAOFactory.crearCitasDAO();
        empleadosDAO = DAOFactory.crearEmpleadosDAO();
        serviciosDAO = DAOFactory.crearServiciosDAO();
        usuariosDAO = DAOFactory.crearUsuariosDAO();
    }

    @Override
    public void agregarCita(Cita cita) {
        citasDAO.agregarCita(cita);
    }

    @Override
    public void eliminarCita(Cita cita) {
        citasDAO.eliminarCita(cita);
    }

    @Override
    public void actualizarCita(Cita cita) {
        citasDAO.actualizarCita(cita);
    }

    @Override
    public Cita obtenerCita(Long id) {
        return citasDAO.obtenerCita(id);
    }

    @Override
    public List<Cita> obtenerCitasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return citasDAO.obtenerCitasPorPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<Cita> obtenerCitas() {
        return citasDAO.obtenerCitas();
    }

    @Override
    public List<Cita> obtenerCitasPorCliente(String nombreCliente) {
        return citasDAO.obtenerCitasPorCliente(nombreCliente);
    }

    @Override
    public List<Cita> obtenerCitasPorEmpleado(Empleado empleado) {
        return citasDAO.obtenerCitasPorEmpleado(empleado);
    }

    @Override
    public List<Cita> obtenerCitasPorEmpleadoClienteFecha(LocalDateTime fecha, Empleado empleado, String cliente){
        return citasDAO.obtenerCitasPorEmpleadoClienteFecha(fecha, empleado, cliente);
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        clientesDAO.agregarCliente(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clientesDAO.eliminarCliente(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clientesDAO.actualizarCliente(cliente);
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return clientesDAO.obtenerCliente(id);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clientesDAO.obtenerClientes();
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        empleadosDAO.agregarEmpleado(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadosDAO.eliminarEmpleado(empleado);
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        empleadosDAO.actualizarEmpleado(empleado);
    }

    @Override
    public Empleado obtenerEmpleado(Long id) {
        return empleadosDAO.obtenerEmpleado(id);
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return empleadosDAO.obtenerEmpleados();
    }

    @Override
    public List<Empleado> obtenerEmpleadosPeluqueros() {
        return empleadosDAO.obtenerEmpleadosPeluqueros();
    }

    @Override
    public void agregarServicio(Servicio servicio) {
        serviciosDAO.agregarServicio(servicio);
    }

    @Override
    public void eliminarServicio(Servicio servicio) {
        serviciosDAO.eliminarServicio(servicio);
    }

    @Override
    public void actualizarServicio(Servicio servicio) {
        serviciosDAO.actualizarServicio(servicio);
    }

    @Override
    public Servicio obtenerServicio(Long id) {
        return serviciosDAO.obtenerServicio(id);
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return serviciosDAO.obtenerServicios();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuariosDAO.agregarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuariosDAO.eliminarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuariosDAO.actualizarUsuario(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuariosDAO.obtenerUsuario(id);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuariosDAO.obtenerUsuarios();
    }
}
