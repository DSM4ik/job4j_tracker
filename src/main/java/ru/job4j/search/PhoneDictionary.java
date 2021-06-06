package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameFind = (p) -> p.getName().contains(key);
        Predicate<Person> phoneFind = (p) -> p.getPhone().contains(key);
        Predicate<Person> surnameFind = (p) -> p.getSurname().contains(key);
        Predicate<Person> addressFind = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = nameFind
                                    .or(phoneFind)
                                    .or(surnameFind)
                                    .or(addressFind);

        ArrayList<Person> result = new ArrayList<Person>();
        for (Person p : persons) {
            if (combine.test(p)) {
                result.add(p);
            }
        }
        return  result;
    }
}
