package org.draszy.service.repository;

import org.draszy.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Szymon on 12.08.2015.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String username);
}