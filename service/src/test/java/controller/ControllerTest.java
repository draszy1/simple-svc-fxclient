package controller;

import com.jayway.restassured.RestAssured;
import configuration.Configuration4Tests;
import org.draszy.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Szymon on 14.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Configuration4Tests.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ControllerTest {

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void getPersonFromByNameTest() {
        Person[] searchResult = given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .when()
                .baseUri("http://localhost/person/surname/Golota")
                .port(port)
                .get()
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Person[].class);

        assertNotNull(searchResult);
        assertThat(searchResult.length, greaterThan(0));
        assertEquals(searchResult[0].getSurname(), "Golota");
        assertEquals(searchResult[0].getName(), "Andrzej");
    }
}
