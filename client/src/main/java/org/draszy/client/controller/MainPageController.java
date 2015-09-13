package org.draszy.client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.draszy.client.service.ServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ComboBox<Integer> idCombo;

    @FXML
    void loadData(ActionEvent event) {
//        Person testPerson = serviceHandler.retrieveData();
//
//        name.setText(testPerson.getName());
//        surname.setText(testPerson.getSurname());
//        age.setText(String.valueOf(testPerson.getAge()));

        idCombo.getItems().setAll(1,3,4);

        // Handle ComboBox event.
        idCombo.setOnAction((changeEvent) -> {
            Integer selectedPerson = idCombo.getSelectionModel().getSelectedItem();
            System.out.println("ComboBox Action (selected: " + selectedPerson.toString() + ")");
        });
    }
}