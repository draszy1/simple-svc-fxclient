package org.draszy.service.repository;

import org.draszy.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Szymon on 20.08.2015.
 */
public interface PersonMongoRepository extends MongoRepository<Person, Long> {

    @Query("{'name' : ?0}")
    List<Person> findByName(String name);
}
