module com.example.unicalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.unicalculator to javafx.fxml;
    opens com.example.unicalculator.controllers to javafx.fxml;

    exports com.example.unicalculator;
    exports com.example.unicalculator.controllers;

}