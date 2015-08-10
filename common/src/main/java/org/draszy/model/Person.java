package org.draszy.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by Szymon on 2015-07-25.
 */
@Data
@Builder
@Entity
public class Person {
    String name;
    String surname;
    int age;
}
