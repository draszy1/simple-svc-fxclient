package configuration;

import org.draszy.model.Person;
import org.draszy.service.business.PersonService;
import org.draszy.service.controller.PersonController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Szymon on 14.10.2015.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {PersonController.class, PersonService.class})
@EnableJpaRepositories(basePackages = {"org.draszy.service.repository.sql"})
@EnableMongoRepositories(basePackages = {"org.draszy.service.repository.mongo"})
@EntityScan(basePackageClasses = {Person.class})
public class Configuration4Tests {
}
