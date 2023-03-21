package org.example.interfacesBO;

import com.roberto_rw.entidades.Cliente;
import com.roberto_rw.entidades.Servicio;

import java.util.List;

public interface IServiciosBO {
    public void agregarServicio(Servicio servicio);

    public void eliminarServicio(Servicio servicio);

    public void actualizarServicio(Servicio servicioe);

    public Servicio obtenerServicio(Long id);
    public List<Servicio> obtenerServicios();
}
