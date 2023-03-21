package org.example.factory;

import org.example.interfacesBO.*;
import org.example.negocio.*;

public class BOFactory {

    public static ICitasBO crearCitasBO(){
        return new CitasBO();
    }

    public static IEmpleadosBO crearEmpleadosBO(){return new EmpleadosBO();}
    public static IUsuariosBO crearUsuariosBO(){
        return new UsuariosBO();
    }
    public static IClientesBO crearClientesBO(){
        return new ClientesBO();
    }
    public static IServiciosBO crearServiciosBO(){
        return new ServiciosBO();
    }
}

