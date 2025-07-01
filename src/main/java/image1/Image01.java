package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image01 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title
        Label title = new Label("Authenticate // Log in");
        title.setFont(new Font("Arial", 24));

        // Username Field
        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");

        // Password Field
        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(200);

        // Layout
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(title, usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

        // Scene
        Scene scene = new Scene(vbox, 400, 400);

        // Stage
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
}
}