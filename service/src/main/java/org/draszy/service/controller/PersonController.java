package org.draszy.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.draszy.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Szymon on 2015-07-25.
 */
@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ResponseEntity<Person> getTestPerson() {
        Person p = Person.builder().age(23).name("Heniek").surname("Zulinski").build();

        return ResponseEntity.ok(p);
    }
}
