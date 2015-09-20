package org.draszy.client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.draszy.client.service.ServiceHandler;
import org.draszy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class MainPageController {

    @Autowired
    private ServiceHandler serviceHandler;

    @FXML
    private TextField surname;

    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private Button loadButton;

    @FXML
    private ComboBox<BigInteger> idCombo;

    private List<Person> people;

    private void fillFieldsById(BigInteger id) {
        people.forEach(person -> {
            if (person.getId().equals(id)) {
                surname.setText(person.getSurname());
                name.setText(person.getName());
                age.setText(Integer.toString(person.getAge()));
            }
        });
    }

    @FXML
    void loadData(ActionEvent event) {
        people = serviceHandler.retrieveData();


        people.forEach(person -> idCombo.getItems().add(person.getId()));

        // Handle ComboBox event.
        idCombo.setOnAction((changeEvent) -> {
            BigInteger selectedPersonId = idCombo.getSelectionModel().getSelectedItem();
            fillFieldsById(selectedPersonId);
        });
    }
}