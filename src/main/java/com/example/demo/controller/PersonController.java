package com.example.demo.controller;

import com.example.demo.repository.PersonRepository;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
    @Secured("ROLE_READ")
    public List<String> listPersons() {
        return personRepository.person();
    }

    @GetMapping("/age-by-name")
    @RolesAllowed("ROLE_WRITE")
    public int ageByName(@RequestParam("name") String name) {
        return personRepository.ageByName(name);
    }

    @GetMapping("/add-new-person")
    @PostAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String addNewPerson(@RequestParam("name") String name, @RequestParam("age") int age) {
        return personRepository.addNewPerson(name, age);
    }

    @GetMapping("/data")
    @PreAuthorize("#username == authentication.principal.username")
    public String userData(@RequestParam("username") String username, Authentication authentication) {
        return "Пользователь: " + username + ", роль: " + authentication.getAuthorities();
    }
}