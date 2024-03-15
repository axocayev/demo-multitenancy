package com.xocayev.multitanancy.demoapp.logic;

import com.xocayev.multitanancy.demoapp.config.SequenceHandler;
import com.xocayev.multitanancy.demoapp.controller.PersonDto;
import com.xocayev.multitanancy.demoapp.pers.entity.Person;
import com.xocayev.multitanancy.demoapp.pers.rep.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonManager {
    private final PersonRepository personRepository;
    private final SequenceHandler sequenceHandler;


    public CreatePersonManager(PersonRepository personRepository, SequenceHandler sequenceHandler) {
        this.personRepository = personRepository;
        this.sequenceHandler = sequenceHandler;
    }

    public Person createPerson(PersonDto personDto) {
        Person person = new Person();
        person.setId(Long.valueOf(sequenceHandler.generateId("person_id_seq")));
        person.setName(personDto.getName());
        person.setAge(personDto.getAge());
        person.setEmail(personDto.getEmail());

        return personRepository.save(person);
    }
}
