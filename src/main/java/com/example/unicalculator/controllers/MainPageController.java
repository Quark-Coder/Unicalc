package com.example.unicalculator.controllers;

import com.example.unicalculator.MainApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    private Stage stage;
    private Scene scene;
    private Parent parent;
    private double currentValue = 0;
    private String currentOperation = "";
    private StringBuilder expression = new StringBuilder();
    private boolean isNewOperation = true;

    @FXML
    private Button but0, but1, but2, but3, but4, but5, but6, but7, but8, but9, calcButton, categoriesBut, clearBut
            , commaBut, cosBut, convertBut, deleteBut, divBut, drBut, equalBut, expBut, historyBut, incBut
            , lgBut, lnBut, percentBut, powBut, rootBut, sinBut, sndBut, subBut, sumBut;

    @FXML
    private GridPane buttonsGroup;

    @FXML
    private AnchorPane contentFrame;

    @FXML
    private TextField inputField;

    @FXML
    private AnchorPane inputFrame;

    @FXML
    private FlowPane mainBar;

    @FXML
    private AnchorPane mainWindow;

    @FXML
    private void initialize() {
        categoriesBut.setOnAction(e -> {
            try {
                switchToCategories(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        convertBut.setOnAction(e -> {
            try {
                switchToConverter(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Button[] buttons = {but0, but1, but2, but3, but4, but5, but6, but7, but8, but9};
        for (Button button : buttons) {
            button.setOnAction(e -> handleButtonPress(button));
        }

        deleteBut.setOnAction(e -> handleDeletePress());
        clearBut.setOnAction(e -> handleClearPress());
        sumBut.setOnAction(e -> handleOperationPress("+"));
        subBut.setOnAction(e -> handleOperationPress("-"));
        incBut.setOnAction(e -> handleOperationPress("*"));
        divBut.setOnAction(e -> handleOperationPress("/"));
        equalBut.setOnAction(e -> handleEqualsPress());
    }

    private void handleButtonPress(Button button) {
        String buttonText = button.getText();

        if (!(buttonText.equals("0") && (expression.length() == 0 || expression.toString().equals("0")))) {
            expression.append(buttonText);
            inputField.setText(expression.toString());
        }
    }

    private void handleOperationPress(String operation) {
        String currentText = inputField.getText();

        if (!currentText.isEmpty() && !isLastCharOperator()) {
            expression.append(operation);
            inputField.setText(expression.toString());
        }
    }

    private boolean isLastCharOperator() {
        if (expression.length() > 0) {
            char lastChar = expression.charAt(expression.length() - 1);
            return lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/';
        }
        return false;
    }

    private void handleEqualsPress() {
        String currentText = inputField.getText();

        if (!currentText.isEmpty() && !isLastCharOperator()) {
            double result = evaluateExpression(expression.toString());

            if (result % 1 == 0) {
                inputField.setText(String.valueOf((int) result));
            } else {
                inputField.setText(String.valueOf(result));
            }
            expression.setLength(0);
            expression.append(inputField.getText());
        }
    }

    private double evaluateExpression(String expr) {
        String[] tokens = expr.split("(?<=[-+*/])|(?=[-+*/])");
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand != 0) {
                        result /= operand;
                    } else {
                        throw new ArithmeticException("Division by zero");
                    }
                    break;
            }
        }
        return result;
    }

    private void handleClearPress() {
        inputField.setText("");
        expression.setLength(0);
    }

    private void handleDeletePress() {
        if (expression.length() > 0) {
            expression.setLength(expression.length() - 1);
            inputField.setText(expression.toString());
        }
    }

    private void switchToCategories(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/filesFXML/categoriesPage-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void switchToConverter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/filesFXML/converterPage-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
