package ru.molokoin.j200.services;

import java.sql.Date;
import java.util.List;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.molokoin.j200.entities.Address;
import ru.molokoin.j200.entities.Client;

@Singleton
public class Repository implements RepositoryFace{
    @PersistenceContext (unitName="Repository")
    private EntityManager em;

    @Override
    public List<Client> getClients() {
        // String sql = "SELECT id, name, client_type, added FROM Clients";
        // Query query = em.createNativeQuery(sql, Client.class);
        // List<Client> clients = query.getResultList();
        // return clients;
        return em.createNamedQuery("Clients.findAll", Client.class).getResultList();
    }

    @Override
    public Client getClientById(Integer id){
        return em.find(Client.class, id);
    }

    @Override
    public Client createClient(Client client) {
        String sql = "SELECT * FROM Clients WHERE name='" + client.getName() + "' AND client_type='" + client.getClient_type() + "'";
        List<Client> list = em.createNativeQuery(sql, Client.class).getResultList();
        if(list.size()>0) client = list.get(0);
        em.merge(client);
        em.flush();
        return client;
    }

    @Override
    public Client updateClient(Client client) {
        // String sql = "SELECT * FROM Clients WHERE name='" + client.getName() + "' AND client_type='" + client.getClient_type() + "'";
        // List<Client> list = em.createNativeQuery(sql, Client.class).getResultList();
        // if(list.size()>0) client = list.get(0);
        em.merge(client);
        em.flush();
        return client;
    }

    @Override
    public void removeClient(Integer id) {
        em.remove(getClientById(id));
        em.flush();
    }


    @Override
    public Address createAddress(Address address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAddress'");
    }
    
}
