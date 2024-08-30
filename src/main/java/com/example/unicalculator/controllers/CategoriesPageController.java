package com.example.unicalculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoriesPageController {

    private Stage stage;
    private Scene scene;
    private Parent parent;

    @FXML
    private Button algebraBut, analyzeBut, calcButton, categoriesBut, chanceBut, combBut, convertBut, dynamBut, graphBut
            , logicBut, matrixBut, mechanicsBut, opticsBut, setsBut, thermoBut;

    @FXML
    private AnchorPane categoriesWindow;

    @FXML
    private FlowPane contentFrame;

    @FXML
    private FlowPane mainBar;

    @FXML
    private AnchorPane mathGroup;

    @FXML
    private Label mathText;

    @FXML
    private AnchorPane physicsGroup;

    @FXML
    private Label physicsText;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private void initialize() {
        calcButton.setOnAction(e -> {
            try {
                switchToMain(e);
            } catch (IOException ex) {throw new RuntimeException(ex);}
        });

        convertBut.setOnAction(e -> {
            try {
                switchToConverter(e);
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

    private void switchToConverter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/filesFXML/converterPage-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
