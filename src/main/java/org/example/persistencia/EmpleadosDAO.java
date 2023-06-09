package org.example.persistencia;

import com.roberto_rw.entidades.Cita;
import com.roberto_rw.entidades.Cliente;
import com.roberto_rw.entidades.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        em.getTransaction().begin();
        em.remove(empleado);
        em.getTransaction().commit();
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        em.getTransaction().begin();
        Empleado nuevoEmpleado = em.find(Empleado.class, empleado.getId());
        nuevoEmpleado.setNombre(empleado.getNombre());
        nuevoEmpleado.setApellido(empleado.getApellido());
        nuevoEmpleado.setPuesto(empleado.getPuesto());
        nuevoEmpleado.setHoraEntrada(empleado.getHoraEntrada());
        nuevoEmpleado.setHoraSalida(empleado.getHoraSalida());
        nuevoEmpleado.setSalario(empleado.getSalario());
        nuevoEmpleado.setTelefono(empleado.getTelefono());
        em.persist(nuevoEmpleado);
        em.getTransaction().commit();
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
        em.getTransaction().begin();
        TypedQuery<Empleado> selectQuery = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
        List<Empleado> empleados = selectQuery.getResultList();
        em.getTransaction().commit();
        return empleados;
    }

    @Override
    public List<Empleado> obtenerEmpleadosPeluqueros() {
        em.getTransaction().begin();
        TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e WHERE e.puesto = :puesto", Empleado.class);
        query.setParameter("puesto", "PELUQUERO");
        List<Empleado> empleados = query.getResultList();
        em.getTransaction().commit();
        return empleados;
    }
}
