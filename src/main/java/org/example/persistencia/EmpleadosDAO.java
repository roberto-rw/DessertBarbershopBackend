package org.example.persistencia;

import com.roberto_rw.entidades.Cita;
import com.roberto_rw.entidades.Cliente;
import com.roberto_rw.entidades.Empleado;
import jakarta.persistence.EntityManager;
import org.example.conexion.IConexionBD;
import org.example.interfacesDAO.IEmpleadosDAO;

import java.util.List;

public class EmpleadosDAO implements IEmpleadosDAO {
    private final IConexionBD conexionBD;
    private final EntityManager em;

    public EmpleadosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.em = this.conexionBD.crearConexion();
    }

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
        em.getTransaction().begin();
        Empleado empleado = em.find(Empleado.class, id);
        em.getTransaction().commit();
        return empleado;
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return null;
    }
}