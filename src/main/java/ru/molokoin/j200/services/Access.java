package ru.molokoin.j200.services;

import java.util.List;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ru.molokoin.j200.entities.Account;

@Singleton
public class Access implements AccessFace{
    @PersistenceContext (unitName="Access")
    private EntityManager em;

    @Override
    public boolean check(String login, String password) {
        String sql = "SELECT id, login, password FROM Accounts WHERE login='" + login + "' AND Password='" + password + "'";
        Query query = em.createNativeQuery(sql, Account.class);
        List<Account> accounts = query.getResultList();
        return (accounts.size()>0);
    }

    @Override
    public List<Account> getAccounts() {
        // String sql = "SELECT id, login, password FROM Accounts";
        // Query query = em.createNativeQuery(sql, Account.class);
        // List<Account> accounts = query.getResultList();
        // return accounts;
        return em.createNamedQuery("Accounts.findAll", Account.class).getResultList();
    }
    
    @Override
    public Account createAccount(Account account) {
        String sql = "SELECT * FROM Accounts WHERE login='" + account.getLogin() 
                + "' AND password='" + account.getPassword()
                + "'";
        List<Account> accounts = em.createNativeQuery(sql, Account.class).getResultList();
        if(accounts.size()>0) account = accounts.get(0);
        em.merge(account);
        em.flush();
        return account;
    }
    
}
