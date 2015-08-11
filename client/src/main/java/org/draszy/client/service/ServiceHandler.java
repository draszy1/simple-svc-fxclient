package org.draszy.client.service;

import lombok.NoArgsConstructor;
import org.draszy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Szymon on 2015-07-25.
 */
@Service
@NoArgsConstructor
public class ServiceHandler {

    @Autowired
    RestTemplate restTemplate;

    public Person retrieveData() {

        //TODO: connect to rest service
        Person person = restTemplate.getForObject("http://localhost:8080/person/test", Person.class);

        //return Person.builder().age(33).name("Cysp").surname("Zysp").build();//test data
        return person;
    }
}
