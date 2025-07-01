package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image11 extends Application {

    Stage window; // Main stage
    Scene formScene, approvalScene;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        // === First Scene ===
        Label formTitle = new Label("Request Access to Vehicle Data");
        formTitle.setFont(new Font("Arial", 22));

        Label carIcon = new Label("🚗");
        carIcon.setFont(new Font("Arial", 60));

        Label vehicleIdLabel = new Label("Vehicle ID");
        TextField vehicleIdField = new TextField();
        vehicleIdField.setPromptText("Enter vehicle ID");

        Label reasonLabel = new Label("Request Reason");
        TextField reasonField = new TextField();
        reasonField.setPromptText("Enter reason (optional)");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white; -fx-font-size: 14;");
        submitButton.setPrefWidth(200);

        VBox formLayout = new VBox(15, formTitle, carIcon, vehicleIdLabel, vehicleIdField, reasonLabel, reasonField, submitButton);
        formLayout.setAlignment(Pos.CENTER);
        formLayout.setPadding(new Insets(30));

        formScene = new Scene(formLayout, 400, 500);

        // === Second Scene (Approval Screen) ===
        Label mechanicIcon = new Label("🧑‍🔧");
        mechanicIcon.setFont(new Font("Arial", 60));

        Label mechanicRequestLabel = new Label();
        mechanicRequestLabel.setFont(new Font("Arial", 16));
        mechanicRequestLabel.setWrapText(true);

        Label reasonDisplayLabel = new Label();
        reasonDisplayLabel.setFont(new Font("Arial", 14));
        reasonDisplayLabel.setWrapText(true);

        Button declineButton = new Button("Decline");
        Button approveButton = new Button("Approve");
        declineButton.setPrefWidth(100);
        approveButton.setPrefWidth(100);

        VBox approvalLayout = new VBox(15, mechanicIcon, mechanicRequestLabel, reasonDisplayLabel, new VBox(10, declineButton, approveButton));
        approvalLayout.setAlignment(Pos.CENTER);
        approvalLayout.setPadding(new Insets(30));

        approvalScene = new Scene(approvalLayout, 400, 500);

        // === Submit Button Action ===
        submitButton.setOnAction(e -> {
            String vehicleId = vehicleIdField.getText();
            String reason = reasonField.getText();

            if (vehicleId.isEmpty()) {
                showAlert("Please enter a Vehicle ID.");
                return;
            }

            mechanicRequestLabel.setText("A mechanic is requesting access to vehicle data for Vehicle ID " + vehicleId);
            reasonDisplayLabel.setText("Reason: " + (reason.isEmpty() ? "No reason provided" : reason));

            window.setScene(approvalScene);
        });

        // === Decline / Approve Button Actions ===
        declineButton.setOnAction(e -> window.setScene(formScene));
        approveButton.setOnAction(e -> window.setScene(formScene));

        // === Show Window ===
        window.setTitle("Vehicle Data Access");
        window.setScene(formScene);
        window.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
}
}