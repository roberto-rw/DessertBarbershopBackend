package org.example.conexion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexionBD implements IConexionBD{
    private static ConexionBD instancia;
    private EntityManagerFactory emFactory;
    private EntityManager em;

    private ConexionBD() {
        //Obtiene acceso al EntityManagerFactory a partir de la persistence unit utilizada
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public static synchronized ConexionBD obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    @Override
    public synchronized EntityManager crearConexion() throws IllegalStateException {
        // Verificar si la conexión ya ha sido creada
        if (em == null || !em.isOpen()) {
            // Si la conexión aún no ha sido creada o se ha cerrado, crear una nueva
            em = emFactory.createEntityManager();
        }
        return em;
    }
}
