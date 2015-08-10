package org.draszy.client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.draszy.client.service.ServiceConfiguration;
import org.draszy.client.service.ServiceHandler;
import org.draszy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainPageController {

    @Autowired
    private ServiceHandler serviceHandler;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField surname;

    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private Button loadButton;

    @FXML
    void initialize() {
        assert surname != null : "fx:id=\"surname\" was not injected: check your FXML file 'MainPage.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainPage.fxml'.";
        assert age != null : "fx:id=\"age\" was not injected: check your FXML file 'MainPage.fxml'.";
        assert loadButton != null : "fx:id=\"loadButton\" was not injected: check your FXML file 'MainPage.fxml'.";
    }

    @FXML
    void loadData(ActionEvent event) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
        serviceHandler = acac.getBean("serviceHandler", ServiceHandler.class);
        Person testPerson = serviceHandler.retrieveData();

        name.setText(testPerson.getName());
        surname.setText(testPerson.getSurname());
        age.setText(String.valueOf(testPerson.getAge()));
    }
}