package com.example.demo.controller;

import com.example.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/list-persons")
    public List<String> listPersons() {
        return personRepository.person();
    }

    @GetMapping("/age-by-name")
    public int ageByName(@RequestParam("name") String name) {
        return personRepository.ageByName(name);
    }

    @GetMapping("/add-new-person")
    public String addNewPerson(@RequestParam("name") String name, @RequestParam("age") int age) {
        return personRepository.addNewPerson(name, age);
    }
}