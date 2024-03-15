package com.xocayev.multitanancy.demoapp.controller;

import com.xocayev.multitanancy.demoapp.logic.CreatePersonManager;
import com.xocayev.multitanancy.demoapp.logic.PersonHelper;
import com.xocayev.multitanancy.demoapp.pers.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
@Transactional
public class PersonController {

    private final PersonHelper personHelper;
    private final CreatePersonManager createPersonManager;

    public PersonController(PersonHelper personHelper, CreatePersonManager createPersonManager) {
        this.personHelper = personHelper;
        this.createPersonManager = createPersonManager;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return new ResponseEntity<>(personHelper.getPerson(id), null, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(personHelper.getPersons(), null, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Person> createPerson(@RequestBody PersonDto personDto) {
        return new ResponseEntity<>(createPersonManager.createPerson(personDto), null, HttpStatus.OK);
    }
}
