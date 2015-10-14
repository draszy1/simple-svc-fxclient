package controller;

import com.jayway.restassured.RestAssured;
import configuration.Configuration4Tests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.springframework.http.HttpStatus.OK;

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
        given()
                .contentType("application/json").
        when()
                .get("/person/name/Andrzej")
        .then()
                .statusCode(OK.value());
    }
}
