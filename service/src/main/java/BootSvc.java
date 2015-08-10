import org.draszy.service.controller.PersonController;
import org.draszy.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Szymon on 2015-07-25.
 */
@ComponentScan(basePackageClasses = {PersonController.class})
@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackageClasses = {Person.class})
public class BootSvc {
    public static void main(String[] args) {
        SpringApplication.run(BootSvc.class, args);
    }
}
