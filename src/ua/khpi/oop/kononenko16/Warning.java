package ua.khpi.oop.kononenko16;

import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;

public class Warning {

    public static void showErrorWithHeaderText(String text) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    public static void showWarnWithHeaderText(String text) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }


}