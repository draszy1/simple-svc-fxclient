package org.draszy.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.draszy.model.Person;
import org.draszy.service.repository.PersonMongoRepository;
import org.draszy.service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    PersonRepository repository;

    @Autowired
    PersonMongoRepository personMongoRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/testsql")
    public ResponseEntity<List<Person>> getTestPerson() {
        List<Person> people = repository.findByName("Tony");

        return ResponseEntity.ok(people);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testmongo")
    public ResponseEntity<List<Person>> getTestPersonFromMongo() {
        List<Person> people = personMongoRepository.findByName("Anna");

        return ResponseEntity.ok(people);
    }
}
