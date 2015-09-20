package org.draszy.client.service;

import lombok.NoArgsConstructor;
import org.draszy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Szymon on 2015-07-25.
 */
@Service
@NoArgsConstructor
public class ServiceHandler {

    @Autowired
    RestTemplate restTemplate;

    public List<Person> retrieveData() {
        ResponseEntity<List<Person>> rateResponse =
                restTemplate.exchange("http://localhost:8080/person/all",
                                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
                                    });

        List<Person> people = rateResponse.getBody();

        return people;
    }
}
