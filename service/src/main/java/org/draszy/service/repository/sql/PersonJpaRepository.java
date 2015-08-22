package org.draszy.service.repository.sql;

import org.draszy.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Szymon on 12.08.2015.
 */
@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);
    List<Person> findBySurname(String surname);
}