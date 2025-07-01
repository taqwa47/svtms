package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image09 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title
        Label title = new Label("Submit Manual Problem Report");
        title.setFont(new Font("Arial", 24));
        title.setAlignment(Pos.CENTER);

        // Document Icon (emoji)
        Label icon = new Label("📄");
        icon.setFont(new Font("Arial", 80));
        icon.setAlignment(Pos.CENTER);

        // Description Input
        Label descriptionLabel = new Label("Description");
        descriptionLabel.setFont(new Font("Arial", 16));
        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Enter problem details");

        // Attachment Input
        Label attachmentLabel = new Label("Attachment");
        attachmentLabel.setFont(new Font("Arial", 16));
        TextField attachmentField = new TextField();
        attachmentField.setPromptText("Add image or audio (optional)");

        // Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white; -fx-font-size: 14;");
        submitButton.setPrefWidth(200);

        // Layout
        VBox vbox = new VBox(20, title, icon, descriptionLabel, descriptionField, attachmentLabel, attachmentField, submitButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));

        // Scene
        Scene scene = new Scene(vbox, 400, 500);
        primaryStage.setTitle("Problem Report");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
}
}