package org.example.negocio;

import com.roberto_rw.entidades.Usuario;
import org.example.fachadas.IPersistencia;
import org.example.fachadas.Persistencia;
import org.example.interfacesBO.IUsuariosBO;

import java.util.List;

public class UsuariosBO implements IUsuariosBO {
    private IPersistencia persistencia = new Persistencia();
    public UsuariosBO(){}
    @Override
    public void agregarUsuario(Usuario usuario) {
        persistencia.agregarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        persistencia.eliminarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        persistencia.actualizarUsuario(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return persistencia.obtenerUsuario(id);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return persistencia.obtenerUsuarios();
    }
}
