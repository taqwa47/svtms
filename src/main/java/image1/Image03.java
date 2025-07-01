package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image03 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // === Critical Alert Section ===
        Label alertTitle = new Label("⚠ CRITICAL ALERT");
        alertTitle.setTextFill(Color.WHITE);
        alertTitle.setFont(new Font("Arial", 22));

        Label alertMessage = new Label("High engine temperature detected");
        alertMessage.setTextFill(Color.WHITE);
        alertMessage.setFont(new Font("Arial", 16));

        VBox alertBox = new VBox(5, alertTitle, alertMessage);
        alertBox.setPadding(new Insets(15));
        alertBox.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(10), Insets.EMPTY)));
        alertBox.setAlignment(Pos.CENTER_LEFT);

        // === Vehicle and Alert Time Section ===
        Label vehicleLabel = new Label("🚚 Vehicle: Truck 123");
        vehicleLabel.setFont(new Font("Arial", 16));

        Label alertTimeLabel = new Label("🕒 Alert Time: 2024-04-24 14:30");
        alertTimeLabel.setFont(new Font("Arial", 16));

        HBox vehicleTimeBox = new HBox(50, vehicleLabel, alertTimeLabel);
        vehicleTimeBox.setPadding(new Insets(15, 0, 15, 0));
        vehicleTimeBox.setAlignment(Pos.CENTER_LEFT);

        // === Alert Log Section ===
        Label alertLogTitle = new Label("📝 Alert Log");
        alertLogTitle.setFont(new Font("Arial", 20));

        Label alertLogEntry = new Label("2024-04-24 14:20\nEngine temperature exceeded the threshold");
        alertLogEntry.setFont(new Font("Arial", 16));
        alertLogEntry.setPadding(new Insets(10));
        alertLogEntry.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(10), Insets.EMPTY)));

        // === Vehicle History Section ===
        Label vehicleHistoryTitle = new Label("🛠 Vehicle History");
        vehicleHistoryTitle.setFont(new Font("Arial", 20));

        Label vehicleHistoryEntry = new Label("2024-04-23\nEngine coolant replaced");
        vehicleHistoryEntry.setFont(new Font("Arial", 16));
        vehicleHistoryEntry.setPadding(new Insets(10));
        vehicleHistoryEntry.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(10), Insets.EMPTY)));

        // === Main Layout ===
        VBox vbox = new VBox(20, alertBox, vehicleTimeBox, alertLogTitle, alertLogEntry, vehicleHistoryTitle, vehicleHistoryEntry);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.TOP_LEFT);

        // === Scene and Stage ===
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setTitle("Critical Alert");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
}
}