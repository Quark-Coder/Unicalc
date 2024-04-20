package com.example.unicalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("filesFXML/mainPage-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 700);
        scene.getStylesheets().add("resources/com/example/unicalculator/CSS/styleMainPage.CSS");

        stage.setTitle("UniCalculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}