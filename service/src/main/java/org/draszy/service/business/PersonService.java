package org.draszy.service.business;

import org.draszy.model.Person;
import org.draszy.service.repository.mongo.PersonMongoRepository;
import org.draszy.service.repository.sql.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 22.08.2015.
 */
@Service
public class PersonService {

    @Autowired
    PersonJpaRepository personJpaRepository;

    @Autowired
    PersonMongoRepository personMongoRepository;

    public List<Person> getAll() {
        List<Person> result = new ArrayList<>();

        result.addAll(personJpaRepository.findAll());
        result.addAll(personMongoRepository.findAll());

        return result;
    }

    public List<Person> getByName(String name) {
        List<Person> result = new ArrayList<>();

        result.addAll(personJpaRepository.findByName(name));
        result.addAll(personMongoRepository.findByName(name));

        return result;
    }

    public List<Person> getBySurname(String surname) {
        List<Person> result = new ArrayList<>();

        result.addAll(personJpaRepository.findBySurname(surname));
        result.addAll(personMongoRepository.findBySurname(surname));

        return result;
    }
}
