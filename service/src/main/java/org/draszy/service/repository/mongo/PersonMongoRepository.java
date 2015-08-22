package org.draszy.service.repository.mongo;

import org.draszy.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Szymon on 20.08.2015.
 */
public interface PersonMongoRepository extends MongoRepository<Person, Long> {
    List<Person> findByName(String name);
    List<Person> findBySurname(String surname);
}
