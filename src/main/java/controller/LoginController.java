package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

import static service.ServiceLocator.authService;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void handleLoginButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean success = authService.login(username, password);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Status");

        if (success) {
            alert.setContentText("Login successful!");
        } else {
            alert.setContentText("Login failed. Try again.");
        }

        alert.showAndWait();
    }
    @FXML
    protected void openRegisterScreen() {
        try {
            String fxmlPath = "/com/example/authenticationservice/register.fxml";
            System.out.println("Loading FXML from: " + fxmlPath);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            if (fxmlLoader.getLocation() == null) {
                throw new RuntimeException("FXML file not found at " + fxmlPath);
            }

            Scene scene = new Scene(fxmlLoader.load(), 300, 200);
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
