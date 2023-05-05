package ru.molokoin.j200.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {

    private long id;
    private String name;
    private Set<Passport> passports;

    public Person() {
        passports = new HashSet<>();
    }

    public Person(long id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Passport> getPassports() {
        return passports;
    }

    public void setPassports(Set<Passport> passports) {
        this.passports = passports;
    }

    public void setPassport(Passport passport){
        passports.add(passport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
