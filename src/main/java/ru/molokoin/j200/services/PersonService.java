package ru.molokoin.j200.services;

import ru.molokoin.j200.model.Person;
import jakarta.ejb.Local;

import java.util.Set;

@Local
public interface PersonService {

    Set<Person> getAllPerson();
}
