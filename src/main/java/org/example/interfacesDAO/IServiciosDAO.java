package org.example.interfacesDAO;

import com.roberto_rw.entidades.Servicio;

import java.util.List;

public interface IServiciosDAO {
    public void agregarServicio(Servicio servicio);

    public void eliminarServicio(Servicio servicio);

    public void actualizarServicio(Servicio servicio);

    public Servicio obtenerServicio(Long id);
    public List<Servicio> obtenerServicios();
}
