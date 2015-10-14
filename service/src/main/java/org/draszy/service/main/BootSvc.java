package org.draszy.service.main;

import org.draszy.model.Person;
import org.draszy.service.business.PersonService;
import org.draszy.service.configuration.SwaggerConfig;
import org.draszy.service.controller.PersonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Szymon on 2015-07-25.
 */
@ComponentScan(basePackageClasses = {PersonController.class, PersonService.class, SwaggerConfig.class})
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.draszy.service.repository.sql"})
@EnableMongoRepositories(basePackages = {"org.draszy.service.repository.mongo"})
@EntityScan(basePackageClasses = {Person.class})
@EnableSwagger2
public class BootSvc {

//    @Bean
//    CommandLineRunner init(PersonMongoRepository personRepository) {
//        Person p1 = Person.builder().id(1).age(10).name("Zylc").surname("Podolski").build();
//        Person p2 = Person.builder().id(2).age(10).name("Wanel").surname("Hart").build();
//
//        return (evt) -> {
//            personRepository.deleteAll();
//            personRepository.save(p1);
//            personRepository.save(p2);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(BootSvc.class, args);
    }
}
