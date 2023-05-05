package ru.molokoin.j200.services;

import ru.molokoin.j200.model.Passport;
import ru.molokoin.j200.model.Person;
import jakarta.ejb.Stateful;

import java.util.HashSet;
import java.util.Set;

@Stateful
public class PersonServiceImpl implements PersonService{
    private static Set<Person> persons;
    static {
        persons = new HashSet<>();
        Person p1 = new Person(1, "Evgenia");
        p1.setPassport(new Passport(5625, 542542));
        persons.add(p1);
        Person p2 = new Person(2, "Ekaterina");
        p2.setPassport(new Passport(5665, 542111));
        persons.add(p2);
        Person p3 = new Person(3, "Artem");
        p3.setPassport(new Passport(1234, 5882542));
        persons.add(p3);
        Person p4 = new Person(4, "Denis");
        p4.setPassport(new Passport(7777, 777777));
        p4.setPassport(new Passport(8888, 888888));
        persons.add(p4);
        Person p5 = new Person(5, "Aleksandr");
        p5.setPassport(new Passport(5555, 565656));
        persons.add(p5);
        Person p6 = new Person(6, "Ivan");
        persons.add(p6);
    }


    @Override
    public Set<Person> getAllPerson() {
        return persons;
    }
}
