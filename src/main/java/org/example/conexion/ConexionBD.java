package org.example.conexion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexionBD implements IConexionBD{
    @Override
    public EntityManager crearConexion() throws IllegalStateException {
        //Obtiene acceso alemFactory a partir de la persistence unit utilizada
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        // Creamos una em(bd) para realizar operaciones con la bd
        EntityManager em = emFactory.createEntityManager();
        return em;
    }
}
