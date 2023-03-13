package org.example.fachadas;

import com.roberto_rw.entidades.*;
import org.example.factory.BOFactory;
import org.example.interfacesBO.ICitasBO;
import org.example.interfacesDAO.IClientesDAO;

import java.time.LocalDateTime;
import java.util.List;

public class LogicaNegocio implements ILogicaNegocio{

    private ICitasBO citasBO;

    public LogicaNegocio(){
        citasBO = BOFactory.crearCitasBO();
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


    //Clientes
    @Override
    public void agregarCliente(Cliente cliente) {

    }

    @Override
    public void eliminarCliente(Cliente cliente) {

    }

    @Override
    public void actualizarCliente(Cliente cliente) {

    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return null;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return null;
    }


    //Empleados
    @Override
    public void agregarEmpleado(Empleado empleado) {

    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {

    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {

    }

    @Override
    public Empleado obtenerEmpleado(Long id) {
        return null;
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return null;
    }


    //Servicios
    @Override
    public void agregarServicio(Servicio servicio) {

    }

    @Override
    public void eliminarServicio(Servicio servicio) {

    }

    @Override
    public void actualizarServicio(Servicio servicio) {

    }

    @Override
    public Servicio obtenerServicio(Long id) {
        return null;
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return null;
    }


    //Usuarios
    @Override
    public void agregarUsuario(Usuario usuario) {

    }

    @Override
    public void eliminarUsuario(Usuario usuario) {

    }

    @Override
    public void actualizarUsuario(Usuario usuario) {

    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return null;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return null;
    }
}
