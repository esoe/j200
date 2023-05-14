package ru.molokoin.j200.services;

import java.util.List;

import jakarta.ejb.Local;
import ru.molokoin.j200.entities.Address;
import ru.molokoin.j200.entities.Client;

@Local
public interface RepositoryFace {
    List<Client> getClients();
    Client createClient(Client client);
    Address createAddress(Address address);
}
