package org.example.negocio;

import com.roberto_rw.entidades.Cliente;
import com.roberto_rw.entidades.Servicio;
import org.example.fachadas.IPersistencia;
import org.example.fachadas.Persistencia;
import org.example.interfacesBO.IServiciosBO;

import java.util.List;

public class ServiciosBO implements IServiciosBO {
    private IPersistencia persistencia = new Persistencia();
    public ServiciosBO(){}
    @Override
    public void agregarServicio(Servicio servicio) {
        persistencia.agregarServicio(servicio);
    }

    @Override
    public void eliminarServicio(Servicio servicio) {
        persistencia.eliminarServicio(servicio);
    }

    @Override
    public void actualizarServicio(Servicio servicio) {
        persistencia.actualizarServicio(servicio);
    }

    @Override
    public Servicio obtenerServicio(Long id) {
        return persistencia.obtenerServicio(id);
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return persistencia.obtenerServicios();
    }
}
