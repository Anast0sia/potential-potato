package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonRepository {
    private final Map<String, Integer> persons = new HashMap<>();

    public List<String> person() {
        return new ArrayList<>(persons.keySet());
    }

    public int ageByName(String name) {
        if (persons.get(name) == null) {
            return -1;
        }
        return persons.get(name);
    }

    public String addNewPerson(String name, int age) {
        if (age < 0 || age > 120) {
            return "Возраст не может быть отрицательным или больше 120";
        }
        persons.put(name, age);
        return "Новый человек добавлен!";
    }
}