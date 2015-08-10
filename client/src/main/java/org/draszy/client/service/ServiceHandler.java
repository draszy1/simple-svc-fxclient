package org.draszy.client.service;

import lombok.NoArgsConstructor;
import org.draszy.model.Person;
import org.springframework.stereotype.Service;

/**
 * Created by Szymon on 2015-07-25.
 */
@Service
@NoArgsConstructor
public class ServiceHandler {
    public Person retrieveData() {

        //TODO: connect to rest service

        return Person.builder().age(33).name("Cysp").surname("Zysp").build();//test data
    }
}
