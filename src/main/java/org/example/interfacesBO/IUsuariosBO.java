package org.example.interfacesBO;

import com.roberto_rw.entidades.Servicio;
import com.roberto_rw.entidades.Usuario;

import java.util.List;

public interface IUsuariosBO {
    public void agregarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);

    public void actualizarUsuario(Usuario usuario);

    public Usuario obtenerUsuario(Long id);
    public List<Usuario> obtenerUsuarios();
}
