package com.xocayev.multitanancy.demoapp.controller;

import com.xocayev.multitanancy.demoapp.pers.entity.Person;
import com.xocayev.multitanancy.demoapp.pers.rep.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
@Transactional
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id ) {
        return new ResponseEntity<>(personRepository.findById(id).get(), null, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(personRepository.findAll(),null, HttpStatus.OK);
    }
}
