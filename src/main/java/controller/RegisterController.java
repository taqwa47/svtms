package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static service.ServiceLocator.authService;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void handleRegisterButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if (authService.register(username, password)) {
            alert.setContentText("Registration successful!");
        } else {
            alert.setContentText("Username taken or invalid.");
        }

        alert.showAndWait();
    }
}

