package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image04 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main Title
        Label title = new Label("Schedule Maintenance");
        title.setFont(new Font("Arial", 26));
        title.setTextFill(Color.WHITE);

        Label appointment = new Label("Appointment");
        appointment.setFont(new Font("Arial", 18));
        appointment.setTextFill(Color.WHITE);

        // Date Picker
        Label dateLabel = new Label("📅 Date:");
        dateLabel.setTextFill(Color.WHITE);
        DatePicker datePicker = new DatePicker();

        // Time Input
        Label timeLabel = new Label("⏰ Time:");
        timeLabel.setTextFill(Color.WHITE);
        TextField timeField = new TextField();
        timeField.setPromptText("Enter time (e.g. 12:30)");

        // Location Input
        Label locationLabel = new Label("📍 Location:");
        locationLabel.setTextFill(Color.WHITE);
        TextField locationField = new TextField();
        locationField.setPromptText("Enter location");

        // Buttons
        Button cancelButton = new Button("Cancel");
        Button confirmButton = new Button("Confirm");

        HBox buttonBox = new HBox(20, cancelButton, confirmButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Top Layout
        VBox topBox = new VBox(15, title, appointment);
        topBox.setAlignment(Pos.CENTER);

        // Form Layout
        GridPane formGrid = new GridPane();
        formGrid.setVgap(15);
        formGrid.setHgap(10);
        formGrid.setAlignment(Pos.CENTER);

        formGrid.add(dateLabel, 0, 0);
        formGrid.add(datePicker, 1, 0);
        formGrid.add(timeLabel, 0, 1);
        formGrid.add(timeField, 1, 1);
        formGrid.add(locationLabel, 0, 2);
        formGrid.add(locationField, 1, 2);

        VBox formBox = new VBox(20, formGrid, buttonBox);
        formBox.setAlignment(Pos.CENTER);

        // Bottom Navigation Bar
        Button homeBtn = new Button("🚗 Home");
        Button alertBtn = new Button("🔔 Alert");
        Button locationBtn = new Button("📍 Location");
        Button maintenanceBtn = new Button("🛠 Maintenance");
        Button infoBtn = new Button("ℹ Info");

        homeBtn.setPrefWidth(100);
        alertBtn.setPrefWidth(100);
        locationBtn.setPrefWidth(100);
        maintenanceBtn.setPrefWidth(100);
        infoBtn.setPrefWidth(100);

        HBox navBar = new HBox(10, homeBtn, alertBtn, locationBtn, maintenanceBtn, infoBtn);
        navBar.setAlignment(Pos.CENTER);
        navBar.setPadding(new Insets(20, 0, 0, 0));

        // Main Layout
        VBox mainLayout = new VBox(30, topBox, formBox, navBar);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        // Scene
        Scene scene = new Scene(mainLayout, 600, 500);
        primaryStage.setTitle("Schedule Maintenance");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
}
}