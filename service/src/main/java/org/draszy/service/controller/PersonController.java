package org.draszy.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.draszy.model.Person;
import org.draszy.service.business.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Szymon on 2015-07-25.
 */
@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = personService.getAll();

        return ResponseEntity.ok(people);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
    public ResponseEntity<List<Person>> getPeopleByName(@PathVariable String name) {
        List<Person> people = personService.getByName(name);

        return ResponseEntity.ok(people);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/surname/{surname}")
    public ResponseEntity<List<Person>> getPeopleBySurname(@PathVariable String surname) {
        List<Person> people = personService.getBySurname(surname);

        return ResponseEntity.ok(people);
    }
}
