package org.example.factory;

import org.example.interfacesBO.ICitasBO;
import org.example.negocio.CitasBO;

public class BOFactory {

    public static ICitasBO crearCitasBO(){
        return new CitasBO();
    }
}
