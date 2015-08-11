package org.draszy.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Szymon on 2015-07-25.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String surname;
    private int age;
}
