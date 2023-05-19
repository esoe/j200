package ru.molokoin.j200.services;

import java.util.List;

import jakarta.ejb.Local;
import ru.molokoin.j200.entities.Address;
import ru.molokoin.j200.entities.Client;

@Local
public interface RepositoryFace {
    List<Client> getClients();
    Client getClientById(Integer id);
    Client createClient(Client client);
    Client updateClient(Client client);
    void removeClient(Integer id);
    Address createAddress(Address address);
    
}
