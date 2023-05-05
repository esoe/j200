package ru.molokoin.j200;

import java.util.HashMap;
import java.util.Map;

public class UserStore {

    private static Map<String, User> users;

    static {
        users = new HashMap<>();
        users.put("andrey", new User("andrey", "123qwe"));
        users.put("misha", new User("misha", "123qwe"));
        users.put("olga", new User("olga", "123qwe"));
        users.put("nastya", new User("nastya", "123qwe"));
    }

    public boolean checkUser(String login, String passwod){
        if(!users.containsKey(login)) return false;
        return users.get(login).getPassword().equals(passwod) ? true : false;
    }
}
