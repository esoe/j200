package ru.molokoin.j200.services;

import java.util.List;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ru.molokoin.j200.entities.Address;
import ru.molokoin.j200.entities.Client;

@Singleton
public class Repository implements RepositoryFace{
    @PersistenceContext (name="j200")
    private EntityManager em;

    @Override
    public List<Client> getClients() {
        String sql = "SELECT * FROM CLIENTS";
        Query query = em.createNativeQuery(sql);
        List<Client> clients = query.getResultList();
        return clients;
        // return em.createNamedQuery("Client.findAll").getResultList();
    }

    /**
     * Добавить проверку наличия клиента в базе, перед добавлением
     */
    @Override
    public Client createClient(Client client) {
        client = em.merge(client);
        return client;
    }

    @Override
    public Address createAddress(Address address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAddress'");
    }
    
}
