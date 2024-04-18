module com.example.unicalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.unicalculator to javafx.fxml;
    exports com.example.unicalculator;
}