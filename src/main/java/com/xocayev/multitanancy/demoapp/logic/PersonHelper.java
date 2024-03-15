package com.xocayev.multitanancy.demoapp.logic;

import com.xocayev.multitanancy.demoapp.pers.entity.Person;
import com.xocayev.multitanancy.demoapp.pers.rep.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonHelper {
    private final PersonRepository personRepository;

    public PersonHelper(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }else{
            throw new RuntimeException("Person not found");
        }
    }
}
