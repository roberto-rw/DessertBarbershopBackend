package org.example.persistencia;

import com.roberto_rw.entidades.Cliente;
import com.roberto_rw.entidades.Servicio;
import com.roberto_rw.entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.conexion.IConexionBD;
import org.example.interfacesDAO.IUsuariosDAO;

import java.util.List;

public class UsuariosDAO implements IUsuariosDAO {
    private final IConexionBD conexionBD;
    private final EntityManager em;

    public UsuariosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.em = this.conexionBD.crearConexion();
    }


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
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, id);
        em.getTransaction().commit();
        return usuario;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        em.getTransaction().begin();
        TypedQuery<Usuario> selectQuery = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
        List<Usuario> usuarios = selectQuery.getResultList();
        em.getTransaction().commit();
        return usuarios;
    }
}
