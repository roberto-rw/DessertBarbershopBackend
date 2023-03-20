package org.example.factory;

import org.example.interfacesBO.ICitasBO;
import org.example.interfacesBO.IEmpleadosBO;
import org.example.negocio.CitasBO;
import org.example.negocio.EmpleadosBO;

public class BOFactory {

    public static ICitasBO crearCitasBO(){
        return new CitasBO();
    }

    public static IEmpleadosBO crearEmpleadosBO(){return new EmpleadosBO();}
}
