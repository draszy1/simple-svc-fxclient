package org.draszy.service.business;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PersonService {

    @Autowired
    PersonJpaRepository personJpaRepository;

    @Autowired
    PersonMongoRepository personMongoRepository;

    public List<Person> getAll() {
        List<Person> result = new ArrayList<>();

        try {
            result.addAll(personJpaRepository.findAll());
        } catch (Exception e) {
            log.error("Problem while reading data from SQL storage!");
        }

        try {
            result.addAll(personMongoRepository.findAll());
        } catch (Exception e) {
            log.error("Problem while reading data from NoSQL storage!");
        }

        return result;
    }

    public List<Person> getByName(String name) {
        List<Person> result = new ArrayList<>();

        try {
            result.addAll(personJpaRepository.findByName(name));
        } catch (Exception e) {
            log.error("Problem while reading data from SQL storage!");
        }

        try {
            result.addAll(personMongoRepository.findByName(name));
        } catch (Exception e) {
            log.error("Problem while reading data from NoSQL storage!");
        }

        return result;
    }

    public List<Person> getBySurname(String surname) {
        List<Person> result = new ArrayList<>();

        try {
            result.addAll(personJpaRepository.findBySurname(surname));
        } catch (Exception e) {
            log.error("Problem while reading data from SQL storage!");
        }

        try {
            result.addAll(personMongoRepository.findBySurname(surname));
        } catch (Exception e) {
            log.error("Problem while reading data from NoSQL storage!");
        }

        return result;
    }
}
