package com.xocayev.multitanancy.demoapp.pers.rep;

import com.xocayev.multitanancy.demoapp.pers.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
