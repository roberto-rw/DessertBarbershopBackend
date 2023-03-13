package org.example.factory;

import com.roberto_rw.entidades.Servicio;
import org.example.conexion.ConexionBD;
import org.example.conexion.IConexionBD;
import org.example.interfacesDAO.*;
import org.example.persistencia.*;

public class DAOFactory {
    private static final IConexionBD conexionBD = new ConexionBD();

    public static ICitasDAO crearCitasDAO(){
        return new CitasDAO(conexionBD);
    }

    public static IClientesDAO crearClientesDAO(){
        return new ClientesDAO(conexionBD);
    }

    public static IEmpleadosDAO crearEmpleadosDAO(){
        return new EmpleadosDAO(conexionBD);
    }

    public static IServiciosDAO crearServiciosDAO(){
        return new ServiciosDAO(conexionBD);
    }

    public static IUsuariosDAO crearUsuariosDAO(){
        return new UsuariosDAO(conexionBD);
    }

}
