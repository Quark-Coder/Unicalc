package com.example.unicalculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ConvertPageController {

    private Stage stage;
    private Scene scene;
    private Parent parent;

    @FXML
    private Button ageBut, calcButton, categoriesBut, convertBut, currencyBut, dataBut, dateBut, discountBut, lengthBut
            , timeBut, velocityBut, volumeBut, weightBut;

    @FXML
    private AnchorPane convertWindow;

    @FXML
    private FlowPane mainBar;

    @FXML
    private FlowPane numSysBut;

    @FXML
    private void initialize() {
        calcButton.setOnAction(e -> {
            try {
                switchToMain(e);
            } catch (IOException ex) {throw new RuntimeException(ex);}
        });

        categoriesBut.setOnAction(e -> {
            try {
                switchToCategories(e);
            } catch (IOException ex) {throw new RuntimeException(ex);}
        });
    }

    private void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/filesFXML/mainPage-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void switchToCategories(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/filesFXML/categoriesPage-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
