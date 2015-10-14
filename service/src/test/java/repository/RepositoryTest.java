package repository;

import configuration.Configuration4Tests;
import org.draszy.model.Person;
import org.draszy.service.repository.sql.PersonJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Szymon on 14.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Configuration4Tests.class)
public class RepositoryTest {

    @Autowired
    PersonJpaRepository personJpaRepository;

    @Test
    public void getByNameTest() {
        List<Person> result = personJpaRepository.findByName("Andrzej");

        assertTrue(result.size() > 0);
        assertEquals(result.get(0).getSurname(), "Golota");
    }
}
