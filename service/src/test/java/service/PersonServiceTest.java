package service;

import configuration.Configuration4Tests;
import org.draszy.model.Person;
import org.draszy.service.business.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Szymon on 19.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Configuration4Tests.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void getPersonByNameTest() {
        List<Person> people = personService.getBySurname("Golota");

        assertEquals(people.get(0).getSurname(), "Golota");
        assertEquals(people.get(0).getName(), "Andrzej");
    }
}
