package ru.molokoin.j200.services;

import java.util.List;

import jakarta.ejb.Local;
import ru.molokoin.j200.models.Client;

@Local
public interface ClientService {
    List<Client> getAllClients();
}
