package org.draszy.client;/**
 * Created by Szymon on 2015-07-25.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.draszy.client.controller.MainPageController;
import org.draszy.client.service.ServiceHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@Slf4j
@ComponentScan(basePackageClasses = {ServiceHandler.class, MainPageController.class})
@SpringBootApplication
public class MainApp extends Application {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            log.info("Starting application");

            Parent root = FXMLLoader.load(getClass().getResource("/views/MainPage.fxml"));

            Scene scene = new Scene(root, 300, 275);

            primaryStage.setTitle("Sample client app");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            log.error("Error while starting JavaFX client app.");
        }
    }

    @Override
    public void stop() throws Exception {
        log.info("Stopping application");
        super.stop();
    }
}
