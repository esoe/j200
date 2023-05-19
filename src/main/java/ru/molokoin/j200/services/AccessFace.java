package ru.molokoin.j200.services;

import java.util.List;

import jakarta.ejb.Local;
import ru.molokoin.j200.entities.Account;

@Local
public interface AccessFace {
    boolean check(String login, String password);
    List<Account> getAccounts();
    Account createAccount(Account account);
}
