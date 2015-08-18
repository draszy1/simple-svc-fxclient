package org.draszy.client.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Szymon on 10.08.2015.
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
