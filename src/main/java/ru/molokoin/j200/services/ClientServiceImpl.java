package ru.molokoin.j200.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.Stateful;
import ru.molokoin.j200.model.Address;
import ru.molokoin.j200.model.Client;

@Stateful
public class ClientServiceImpl implements ClientService {
    private static List<Client> clients;

    /**Заполняем данные для пары клиентов */
    static {
        clients = new ArrayList<>();
        Client c1 = new Client(1, "Евгения".toCharArray(), "Юридическое лицо".toCharArray(), Date.valueOf("2023-05-08"));
        Address a1 = new Address("192.168.1.0".toCharArray(), "00:00:00:00:00:00:00:00".toCharArray(), "router".toCharArray(), "СПб".toCharArray(), c1);
        Address a2 = new Address("192.168.1.1".toCharArray(), "00:00:00:00:00:00:00:01".toCharArray(), "router".toCharArray(), "СПб".toCharArray(), c1);
        List<Address> addresses = new ArrayList<>();
        addresses.add(a1);
        addresses.add(a2);
        c1.setAddresses(addresses);
        clients.add(c1);

        Client c2 = new Client(2, "Екатерина".toCharArray(), "Физическое лицо".toCharArray(), Date.valueOf("2023-05-09"));
        a1 = new Address("10.168.1.0".toCharArray(), "00:00:00:00:00:00:00:02".toCharArray(), "router".toCharArray(), "МСК".toCharArray(), c2);
        addresses = new ArrayList<>();
        addresses.add(a1);
        c2.setAddresses(addresses);
        clients.add(c2);
    }

    @Override
    public List<Client> getAllClients() {
        return clients;
    }
    
}
